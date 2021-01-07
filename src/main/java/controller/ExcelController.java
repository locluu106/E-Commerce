 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ProductDetailsEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.ProductDetailsRepository;

/**
 *
 * @author HP
 */
@Controller
public class ExcelController {

    @Autowired
    ProductDetailsRepository productDetailsRepo;

        @RequestMapping(value = "/productDetailsListReport", method = RequestMethod.GET)
        public String getExcelProductDetails(Model model) {
            List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.findAll();
            model.addAttribute("productDetailsList", productDetailsList);
            
            return "admin/productDetailsListReport";
        }

        @RequestMapping(value = "/export1", method = RequestMethod.GET)
        public ModelAndView getExcel() {
            List<ProductDetailsEntity> productDetailsList = (List<ProductDetailsEntity>) productDetailsRepo.findAll();
            return new ModelAndView("ProductDetailsListExcel", "productDetailsList", productDetailsList);
        }
}
