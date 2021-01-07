package controller;

import entity.CustomerEntity;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import entity.ProductDetailsEntity;
import entity.ProductEntity;
import entity.UserEntity;
import entity.UserRoleEntity;
import static java.util.Collections.list;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.CustomerRepository;
import repository.OrderDetailsRepository;
import repository.OrdersRepository;
import repository.ProductDetailsRepository;
import repository.ProductRepository;
import repository.UserRepository;
import repository.UserRoleRepository;

@Controller
public class LoginController {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    ProductDetailsRepository productDetailsRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserRoleRepository userRoleRepo;

    @Autowired
    OrdersRepository orderRepo;

    @Autowired
    ProductRepository productRepo;
    
    @Autowired
    OrderDetailsRepository OrderDetailsRepo;
    

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String ShowRegister(Model model) {
        UserEntity user = new UserEntity();
        UserRoleEntity userRole = new UserRoleEntity();
        CustomerEntity customer = new CustomerEntity();
        user.setCustomer(customer);
        user.setUser_roles(userRole);
        model.addAttribute("user", user);
        return "/register";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String newUser(Model model, UserEntity user) {
        UserEntity users = userRepo.findByusername(user.getUsername());
        if (users == null) {
            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setRole("ROLE_USER");
            userRole.setUsername(user.getUsername());

            user.setEnabled(1);
            user.setUser_roles(userRole);

            CustomerEntity customer = user.getCustomer();
            customerRepo.save(customer);
            userRoleRepo.save(userRole);
            userRepo.save(user);
            
            
            
            String errorMessage1 = "successful registration";
            model.addAttribute("errorMessage1", errorMessage1);
            return "/register";

        } else {
            String errorMessage = "User name already exists";
            model.addAttribute("errorMessage", errorMessage);

            UserRoleEntity userRole = new UserRoleEntity();
            CustomerEntity customer = new CustomerEntity();
            user.setCustomer(customer);
            user.setUser_roles(userRole);
            model.addAttribute("user", user);
            return "/register";
        }
    }
    
    

    @RequestMapping(value = "user/homeUser", method = RequestMethod.GET)
    public String showPage(Model model) {

        String lastName = "";
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity user = userRepo.getCustomerByUserName(userName);
        lastName = user.getUsername();

        model.addAttribute("lastName", lastName);
        return "user/homeUser";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.getCustomerByUserName(userName);

        if (user == null) {
            List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.getShowHomeProductLimit10();
            List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
            model.addAttribute("productList", productList);
            model.addAttribute("productDetailsList", productDetailsList);
        } else {
            String lastName = "";
            List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.getShowHomeProductLimit10();
            List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
            model.addAttribute("productList", productList);
            model.addAttribute("productDetailsList", productDetailsList);
            lastName = user.getUsername();
            model.addAttribute("lastName", lastName);
        }
        return "/home";
    }

    @RequestMapping(value = "/user/infomation", method = RequestMethod.GET)
    public String showInfomation(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.getCustomerByUserName(userName);

        model.addAttribute("users", user);

        return "user/homeUser";
    }

    @RequestMapping(value = "/user/userOrder", method = RequestMethod.GET)
    public String ShowUserOrder(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.getCustomerByUserName(userName);
        int customerId = user.getCustomer().getCustomerId();
        int userId = user.getUserId();
        //String
        List<OrdersEntity> ordersList = orderRepo.getOrderByUser(userId, customerId);

        model.addAttribute("ordersList", ordersList);

        return "/user/userOrder";
    }
    
    @RequestMapping(value = "/viewOrder/{id}", method = RequestMethod.GET)
    public String viewOrder(@PathVariable(value = "id") int orderId, Model model) {

       List<OrderDetailsEntity> orderList = (List<OrderDetailsEntity>) OrderDetailsRepo.getOrderUser(orderId);
        model.addAttribute("orderList", orderList);
        return "/user/userOrderDetails";
    }

    
}
