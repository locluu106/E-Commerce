package controller;

import entity.CategoryEntity;
import entity.CustomerEntity;
import entity.OrderDetailsEntity;
import entity.OrdersEntity;

import entity.ProductEntity;
import entity.UserEntity;
import entity.UserRoleEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.CategoryRepository;
import repository.CustomerRepository;
import repository.OrderDetailsRepository;
import repository.OrdersRepository;

import repository.ProductRepository;
import repository.UserRepository;
import repository.UserRoleRepository;

@Controller
public class LoginController {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    private CategoryRepository categoryRepo;

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
            user.setRegisterDate(LocalDate.now());
            user.setUser_roles(userRole);

            CustomerEntity customer = user.getCustomer();
            customerRepo.save(customer);
            userRoleRepo.save(userRole);
            userRepo.save(user);

            return "/login";

        } else {
            String errorMessage = "User name already exists";
            model.addAttribute("errorMessage", errorMessage);
            UserRoleEntity userRole = new UserRoleEntity();
            CustomerEntity customer = new CustomerEntity();
            user.setCustomer(customer);
            user.setUser_roles(userRole);
            model.addAttribute("user", user);
            return "/account";
        }
    }

    @RequestMapping(value = "user/homeUser", method = RequestMethod.GET)
    public String showPage(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        int userId = user.getUserId();

        List<OrdersEntity> ordersList = orderRepo.getOrderByUser(userId);
        model.addAttribute("ordersList", ordersList);
        model.addAttribute("user", user);
        return "/viewOrder";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHome(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);
        if (user == null) {
            List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();
            List<ProductEntity> product = (List<ProductEntity>) productRepo.findAll();
            List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
            model.addAttribute("productSale", productSale);
            model.addAttribute("category", category);
            model.addAttribute("product", product);
        } else {
            String lastName = "";
            lastName = user.getUsername();
            List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();
            List<ProductEntity> product = (List<ProductEntity>) productRepo.findAll();
            List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
            model.addAttribute("productSale", productSale);
            model.addAttribute("product", product);
            model.addAttribute("category", category);
            model.addAttribute("lastName", lastName);
        }
        return "/index";
    }

    @RequestMapping(value = "/user/userOrder", method = RequestMethod.GET)
    public String ShowUserOrder(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        int userId = user.getUserId();

        List<OrdersEntity> ordersList = orderRepo.getOrderByUser(userId);
        model.addAttribute("ordersList", ordersList);
        return "/viewOrder";
    }

    @RequestMapping(value = "/viewOrder/{id}", method = RequestMethod.GET)
    public String viewOrder(@PathVariable(value = "id") int orderId, Model model) {
        List<OrderDetailsEntity> orderList = (List<OrderDetailsEntity>) OrderDetailsRepo.getOrderUser(orderId);
        model.addAttribute("orderList", orderList);
        return "/viewOrderDetails";
    }

}
