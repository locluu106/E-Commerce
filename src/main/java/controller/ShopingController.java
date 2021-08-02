package controller;

import component.CartComponent;
import entity.CreditCardEntity;
import entity.CustomerEntity;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import entity.PaymentEntity;
import entity.ProductEntity;

import entity.UserEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CreditCardRepository;
import repository.CustomerRepository;
import repository.OrderDetailsRepository;

import repository.OrdersRepository;
import repository.PaymentRepository;
import repository.ProductRepository;
import repository.UserRepository;

@Controller
@Scope("session")
@RequestMapping(value = "/")
public class ShopingController {

    @Autowired
    CartComponent cart;

    @Autowired
    CreditCardRepository cardRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    OrdersRepository orderRepo;

    @Autowired
    PaymentRepository paymentRepo;

    @Autowired
    OrderDetailsRepository orderDetailsRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.GET)
    public String addToCart(@PathVariable(value = "productId") int productId, Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            ProductEntity product = productRepo.findByProductId(productId);
            cart.addItems(product);
            model.addAttribute("order", cart.getOrder());

            return "redirect:/cart";
        }
        ProductEntity product = productRepo.findByProductId(productId);
        cart.addItems(product);
        model.addAttribute("order", cart.getOrder());
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            model.addAttribute("order", cart.getOrder());
        return "/cart";
        }
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);
        model.addAttribute("order", cart.getOrder());
        return "/cart";
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
    public String removeItems(@PathVariable(value = "productId") int productId, Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            ProductEntity product = productRepo.findByProductId(productId);
            cart.removeItems(product);
            model.addAttribute("order", cart.getOrder());

            return "redirect:/cart";
        }

        ProductEntity product = productRepo.findByProductId(productId);
        cart.removeItems(product);
        model.addAttribute("order", cart.getOrder());
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);
        return "redirect:/cart";
    }

    @RequestMapping(value = "/update/{productId}", method = RequestMethod.POST)
    public String updateQuantity(@PathVariable(name = "productId") int productId,
            @RequestParam(name = "quantity") int quantity,
            Model model, ProductEntity product) {

        List<OrderDetailsEntity> orderDetailList = cart.getOrder().getOrderDetails();
        ProductEntity quantityProduct = productRepo.findByProductId(productId);
        int x = quantityProduct.getNumberProduct();
        if (x < quantity) {
            model.addAttribute("errorMessage", "Số Lượng Không Đủ, còn " + x + " sản phẩm");
            model.addAttribute("order", cart.getOrder());
            return "/cart";
        }
        for (int i = 0; i < orderDetailList.size(); i++) {
            OrderDetailsEntity orderDetails = orderDetailList.get(i);
            if (orderDetails.getProduct().getProductId() == product.getProductId()) {
                OrderDetailsEntity orderDetail = orderDetailList.get(i);
                orderDetail.setQuantity(quantity);
                cart.getOrder().getOrderDetails().set(i, orderDetail);
                cart.getOrder().getOrderDetails();
            }
        }
        model.addAttribute("order", cart.getOrder());

        return "/cart";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String checkOrder(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(username);
        List<OrderDetailsEntity> orderDetailsList = cart.getOrder().getOrderDetails();
        if (orderDetailsList.isEmpty()) {
            model.addAttribute("errorMessage", "Giỏ hàng hiện đang trống!");
            return "/cart";
        } else if (user == null) {
            model.addAttribute("order", cart.getOrder());
            return "/login";

        } else {

            cart.getOrder().setUser(user);
            model.addAttribute("order", cart.getOrder());
            return "/checkout";

        }
    }

    @RequestMapping(value = "/paymentProduct", method = RequestMethod.POST)
    public String formPayment(@RequestParam(name = "cardName") String creditCardName,
            @RequestParam(name = "cardNumber") String creditCardNumber,
            @RequestParam(name = "cvv") String securityCode,
            @RequestParam(name = "exDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expirationDate, Model model) {

        LocalDate exDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(expirationDate));
        CreditCardEntity CreditCard = cardRepo.getPayment(creditCardName, creditCardNumber, exDate, securityCode);

        if (CreditCard == null) {
            model.addAttribute("order", cart.getOrder());
            model.addAttribute("errorMessage", "Thông tin thẻ sai vui lòng nhập lại");
            return "/checkout";
        } else {
            //check amout in credit
            double total = cart.getOrder().getTotal();
            if (total >= CreditCard.getAmount()) {
                model.addAttribute("order", cart.getOrder());
                model.addAttribute("errorMessage", "Số tiền thanh toán không đủ");
                return "/checkout";
            } else {
                double blance = CreditCard.getAmount() - total;
                CreditCard.setAmount(blance);
                cardRepo.save(CreditCard);

                OrdersEntity newOrder = cart.getOrder();
                newOrder.setUser(cart.getOrder().getUser());
                newOrder.setOrderDate(LocalDate.now());

                newOrder.setOrderStatus("Pending");
                orderRepo.save(newOrder);

                PaymentEntity payment = new PaymentEntity();
                payment.setOrders(newOrder);
                payment.setCreditCard(CreditCard);
                payment.setPaymentDate(LocalDate.now());
                payment.setAmount(total);
                paymentRepo.save(payment);

                List<OrderDetailsEntity> list = cart.getOrder().getOrderDetails();
                for (OrderDetailsEntity od : list) {
                    od.setOrders(newOrder);

                    orderDetailsRepo.save(od);

                }
                for (OrderDetailsEntity order : list) {
                    int i = order.getProduct().getProductId();
                    ProductEntity product = productRepo.findByProductId(i);
                    int qttO = order.getQuantity();
                    int qttP = product.getNumberProduct();
                    int rest = qttP - qttO;
                    product.setNumberProduct(rest);
                    productRepo.save(product);
                }

                SimpleMailMessage mess = new SimpleMailMessage();
                mess.setTo(newOrder.getUser().getCustomer().getEmail());
                mess.setSubject("Bin Mobile");
                mess.setText("BAN DA DAT HANG THANH CONG \n"
                        + newOrder.getOrderDetails().toString());
                javaMailSender.send(mess);
            }

            cart.getOrder().getOrderDetails().clear();
            return "/thank";

        }
    }
}
