package controller;

import component.CartComponent;
import entity.CreditCardEntity;
import entity.CustomerEntity;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import entity.PaymentEntity;
import entity.ProductDetailsEntity;
import entity.UserEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.beans.binding.Bindings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
import repository.ProductDetailsRepository;
import repository.SexRepository;
import repository.UserRepository;

@Controller
@Scope("session")
@RequestMapping(value = "/")
public class ShopingController {

    @Autowired
    ProductDetailsRepository productDetailsRepo;

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
    SexRepository sexRepo;

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/addToCart/{productDetailsId}", method = RequestMethod.GET)
    public String addToCart(@PathVariable(value = "productDetailsId") int productDetailsId, Model model) {
        ProductDetailsEntity productDetails = (ProductDetailsEntity) productDetailsRepo.findByProductDetailsId(productDetailsId);
        cart.addItems(productDetails);
        model.addAttribute("order", cart.getOrder());

        return "/checkout/cart";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String showCart(Model model) {
        model.addAttribute("order", cart.getOrder());
        return "/checkout/cart";
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String returnHome(Model model) {
        List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.getShowHomeProductLimit10();
        cart.getOrder().getOrderDetailsList().clear();
        
        return "redirect:/";
    }

    @RequestMapping(value = "/remove/{productDetailsId}", method = RequestMethod.GET)
    public String removeItems(@PathVariable(value = "productDetailsId") int productDetailsId, Model model) {
        ProductDetailsEntity productDetails = (ProductDetailsEntity) productDetailsRepo.findByProductDetailsId(productDetailsId);
        cart.removeItems(productDetails);
        model.addAttribute("order", cart.getOrder());

        return "/checkout/cart";
    }

    @RequestMapping(value = "/update/{productDetailsId}", method = RequestMethod.POST)
    public String updateQuantity(@PathVariable(name = "productDetailsId") int productDetailsId,
            @RequestParam(name = "quantity") int quantity,
            Model model, ProductDetailsEntity productDetails) {

        List<OrderDetailsEntity> orderDetailList = cart.getOrder().getOrderDetailsList();
        for (int i = 0; i < orderDetailList.size(); i++) {
            OrderDetailsEntity orderDetails = orderDetailList.get(i);
            if (orderDetails.getProductDetails().getProductDetailsId() == productDetails.getProductDetailsId()) {
                OrderDetailsEntity orderDetail = orderDetailList.get(i);
                orderDetail.setQuantity(quantity);
                cart.getOrder().getOrderDetailsList().set(i, orderDetail);
                cart.getOrder().setOrderDetailsList(orderDetailList);
            }
        }
        model.addAttribute("order", cart.getOrder());

        return "/checkout/cart";
    }

    @RequestMapping(value = "/inforCustomer", method = RequestMethod.GET)
    public String showFormCustomer(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.getCustomerByUserName(userName);
        List<OrderDetailsEntity> orderDetailsList = cart.getOrder().getOrderDetailsList();
        if (orderDetailsList.isEmpty()) {
            model.addAttribute("errorMessage", "Your cart is empty");
            return "/checkout/cart";
        } else if (user == null) {
            CustomerEntity customer = new CustomerEntity();
            String[] sex = {"Men", "Women"};
            model.addAttribute("sex", sex);
            model.addAttribute("customer", customer);
            return "/checkout/check";
        } else {
            model.addAttribute("users", user);
            return "/checkout/payment";

        }
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String infoCustomer(CustomerEntity customer, Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.getCustomerByUserName(userName);
        if (user == null) {
            cart.getOrder().setCustomer(customer);
            model.addAttribute("cart", cart.getOrder());
            return "/checkout/payment";
        } else {
            return "/checkout/payment";
        }

    }

    @RequestMapping(value = "/paymentProduct", method = RequestMethod.POST)
    public String formPayment(@RequestParam(name = "cardName") String creditCardName,
            @RequestParam(name = "cardNumber") String creditCardNumber,
            @RequestParam(name = "cvv") String securityCode,
            @RequestParam(name = "exDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date expirationDate, Model model) {

        LocalDate exDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(expirationDate));
        CreditCardEntity card = cardRepo.getPayment(creditCardName, creditCardNumber, exDate, securityCode);

        if (card == null) {
            model.addAttribute("errorMessage", "Wrong card information please re-enter");
            return "/checkout/payment";           
        } else {
            //check amout in credit
            double total = cart.getOrder().getTotal();
            if (total >= card.getAmount()) {            
                model.addAttribute("errorMessage", "payment amount is not enoug");
                return "/checkout/payment";                
            } else {                
                String userName = SecurityContextHolder.getContext().getAuthentication().getName();
                UserEntity user = userRepo.getCustomerByUserName(userName);
                if (user == null) {
                    double blance = card.getAmount() - total;
                    card.setAmount(blance);
                    cardRepo.save(card);

                    CustomerEntity newCustomer = cart.getOrder().getCustomer();
                    customerRepo.save(newCustomer);

                    OrdersEntity newOrders = cart.getOrder();
                    newOrders.setCustomer(newCustomer);
                    newOrders.setOrderDate(LocalDate.now());
                    orderRepo.save(newOrders);

                    PaymentEntity payment = new PaymentEntity();
                    payment.setOrders(newOrders);
                    payment.setCreditCard(card);
                    payment.setPaymentDate(LocalDate.now());
                    paymentRepo.save(payment);

                    List<OrderDetailsEntity> orderDetailsList = cart.getOrder().getOrderDetailsList();
                    for (OrderDetailsEntity od : orderDetailsList) {
                        od.setOrders(newOrders);

                        orderDetailsRepo.save(od);
                    }

                } else {

                    double blance = card.getAmount() - total;
                    card.setAmount(blance);
                    cardRepo.save(card);

                    OrdersEntity newOrders = cart.getOrder();
                    newOrders.setCustomer(user.getCustomer());
                    newOrders.setOrderDate(LocalDate.now());
                    orderRepo.save(newOrders);

                    PaymentEntity payment = new PaymentEntity();
                    payment.setOrders(newOrders);
                    payment.setCreditCard(card);
                    payment.setPaymentDate(LocalDate.now());
                    paymentRepo.save(payment);
                    
                    List<OrderDetailsEntity> orderDetailsList = cart.getOrder().getOrderDetailsList();
                    for (OrderDetailsEntity od : orderDetailsList) {
                        od.setOrders(newOrders);

                        orderDetailsRepo.save(od);
                    }
                }
                cart.getOrder().getOrderDetailsList().clear();
                return "/thanks";
            }

        }
    }
}
