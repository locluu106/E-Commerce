/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.OrdersEntity;
import entity.ProductDetailsEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.OrdersRepository;
import repository.ProductDetailsRepository;

/**
 *
 * @author HP
 */

@Controller
public class SearchController {

    @Autowired
    ProductDetailsRepository productDetailsRepo;
    
    @Autowired
    OrdersRepository orderRepo;

    
    //---Search Product Details---//
    @RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
    public String searchProductAdmin(@RequestParam(name = "searchText") String searchText, String searchText1, Model model) {
        searchText = "%" + searchText + "%";
        List<ProductDetailsEntity> productDetailsList = productDetailsRepo.findByProductDetailsNameLike(searchText);
        model.addAttribute("productDetailsList", productDetailsList);

        return "admin/listProductDetails";
    }
    
     //---Search Product Details---//
       @RequestMapping(value = "/searchOrder", method = RequestMethod.GET)
    public String searchOrder( OrdersEntity orders, @RequestParam(name = "searchText") String searchText, Model model) {
        searchText = "%" + searchText + "%";
        
        List<OrdersEntity> orderList = orderRepo.getByCustomerNameLike(searchText);
        model.addAttribute("orderList", orderList);

        return "admin/listOrder";
    }
}
