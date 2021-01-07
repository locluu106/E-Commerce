package controller;

import entity.ProductDetailsEntity;
import entity.ProductEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.ProductDetailsRepository;
import repository.ProductRepository;

@Controller

public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ProductDetailsRepository productDetailsRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.getShowHomeProductLimit10();
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("productDetailsList", productDetailsList);
        return "/home";

    }

    @RequestMapping(value = "/women", method = RequestMethod.GET)
    public String showProductWomen(Model model) {
        List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.getSexId(2);
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("productDetailsList", productDetailsList);
        return "/women/women";

    }
    
    @RequestMapping(value = "/men", method = RequestMethod.GET)
    public String showProductMen(Model model) {
        List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.getSexId(1);
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("productDetailsList", productDetailsList);
        return "/men/men";

    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String showProduct(Model model) {
        List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.findAll();
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("productDetailsList", productDetailsList);
        
        return "/product/product";

    }
    
    // ------------Show Product Type
    @RequestMapping(value = "/productType/{productId}",method = RequestMethod.GET)
    public String showProductType(Model model,@PathVariable(value = "productId") int productId){
        List<ProductDetailsEntity> productDetailsList = 
                (List<ProductDetailsEntity>) productDetailsRepo.getProductType(productId);
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        model.addAttribute("productList", productList); 
        model.addAttribute("productDetailsList", productDetailsList);
        return "/product/product";
    }

    @RequestMapping(value = "/details/{productDetailsId}", method = RequestMethod.GET)
    public String showProductDetails(@PathVariable(value = "productDetailsId") int productDetailsId, Model model) {
        ProductDetailsEntity productDetails = 
                (ProductDetailsEntity) productDetailsRepo.findByProductDetailsId(productDetailsId);
        List<ProductDetailsEntity> productDetailsList = 
                (List<ProductDetailsEntity>) productDetailsRepo.getShowHomeProductLimit4();
        model.addAttribute("productDetailsList", productDetailsList);
        model.addAttribute("productDetails", productDetails);
        return "/product/productDetails";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchProduct(@RequestParam(name = "searchText") String searchText, Model model) {

        String searchText1 = "%" + searchText + "%";
        List<ProductDetailsEntity> productDetailsList = 
                productDetailsRepo.searchProduct(searchText, searchText, searchText);

        model.addAttribute("productDetailsList", productDetailsList);
        model.addAttribute("searchText", searchText);

        return "/product/product";
    }
}
