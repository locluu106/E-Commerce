package controller;

import entity.CategoryEntity;
import entity.ProductEntity;
import entity.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import repository.CategoryRepository;

import repository.ProductRepository;
import repository.UserRepository;

@Controller

public class HomeController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
        List<ProductEntity> product = (List<ProductEntity>) productRepo.findAll();

        List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();

        model.addAttribute("category", category);
        model.addAttribute("product", product);
        model.addAttribute("productSale", productSale);
        return "/index";

    }

    @GetMapping("/404")
    public ModelAndView Erro() {
        ModelAndView erro = new ModelAndView("/404");
        return erro;
    }

    @GetMapping("/seach-price/{prince1}/{prince2}")
    public String seachBetween(Model model, @PathVariable(value = "prince1") double price1, @PathVariable(value = "prince2") double price2) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            List<ProductEntity> product = (List<ProductEntity>) productRepo.findByPriceBetween(price1, price2);
            List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
            List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();

            model.addAttribute("productSale", productSale);
            model.addAttribute("category", category);
            model.addAttribute("product", product);
            return "/index";
        }

        List<ProductEntity> product = (List<ProductEntity>) productRepo.findByPriceBetween(price1, price2);
        List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
        List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();

        model.addAttribute("productSale", productSale);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);
        return "/index";
    }

    @GetMapping("/seach-price/{prince}")
    public String seachPriceGreaterThanEqual(Model model, @PathVariable(value = "prince") double price) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            List<ProductEntity> product = (List<ProductEntity>) productRepo.findByPriceGreaterThanEqual(price);
            List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
            List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();

            model.addAttribute("productSale", productSale);
            model.addAttribute("category", category);
            model.addAttribute("product", product);
            return "/index";
        }
        List<ProductEntity> product = (List<ProductEntity>) productRepo.findByPriceGreaterThanEqual(price);
        List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
        List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();

        model.addAttribute("productSale", productSale);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);
        return "/index";
    }

    @GetMapping("/category/{name}")
    public String showCateinProduct(@PathVariable(value = "name") String name, Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();
            List<ProductEntity> product = (List<ProductEntity>) productRepo.findByCategory(name);
            List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
            model.addAttribute("productSale", productSale);
            model.addAttribute("category", category);
            model.addAttribute("product", product);
            return "/index";
        }
        List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();
        List<ProductEntity> product = (List<ProductEntity>) productRepo.findByCategory(name);
        List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
        model.addAttribute("productSale", productSale);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);
        return "/index";
    }

    @RequestMapping(value = "/details/{productId}", method = RequestMethod.GET)
    public String showProductDetails(@PathVariable(value = "productId") int productId, Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            ProductEntity product = productRepo.findByProductId(productId);
            List<ProductEntity> productDetailsList = (List<ProductEntity>) productRepo.findProduct();
            model.addAttribute("productDetailsList", productDetailsList);
            model.addAttribute("product", product);
            return "/product";

        }

        ProductEntity product = productRepo.findByProductId(productId);
        List<ProductEntity> productDetailsList = (List<ProductEntity>) productRepo.findProduct();
        model.addAttribute("productDetailsList", productDetailsList);
        model.addAttribute("product", product);
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);
        return "/product";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchProductAdmin(@RequestParam(name = "searchText") String searchText, String searchText1, Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByusername(userName);

        if (user == null) {
            searchText1 = "%" + searchText + "%";
            List<ProductEntity> product = (List<ProductEntity>) productRepo.findByNameLike(searchText1);
            List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();

            List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
            model.addAttribute("productSale", productSale);
            model.addAttribute("category", category);

            model.addAttribute("product", product);
            model.addAttribute("searchText", searchText);

            return "/index";
        }

        searchText1 = "%" + searchText + "%";
        List<ProductEntity> product = (List<ProductEntity>) productRepo.findByNameLike(searchText1);
        List<CategoryEntity> category = (List<CategoryEntity>) categoryRepo.findAll();

        List<ProductEntity> productSale = (List<ProductEntity>) productRepo.productSale();
        model.addAttribute("productSale", productSale);
        model.addAttribute("category", category);

        model.addAttribute("product", product);
        model.addAttribute("searchText", searchText);
        String lastName = user.getUsername();
        model.addAttribute("lastName", lastName);

        return "/index";
    }

}
