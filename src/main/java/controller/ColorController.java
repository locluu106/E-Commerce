/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ColorEntity;
import entity.ProductDetailsEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ColorRepository;
import repository.ProductDetailsRepository;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/")
public class ColorController {

    @Autowired
    ColorRepository colorRepo;

    @Autowired
    ProductDetailsRepository productDetailsRepo;

    @RequestMapping(value = "/listColor", method = RequestMethod.GET)
    public String showColor(Model model) {
        List<ColorEntity> colorList = (List<ColorEntity>) colorRepo.findAll();
        model.addAttribute("colorList", colorList);

        return "admin/listColor";
    }

    @RequestMapping(value = "/addColor", method = RequestMethod.GET)
    public String setupColor(Model model) {
        model.addAttribute("color", new ColorEntity());

        return "admin/addColor";
    }

    //save 
    @RequestMapping(value = "/addColor", method = RequestMethod.POST)
    public String saveSetupColor(ColorEntity color, Model model) {
        colorRepo.save(color);
        model.addAttribute("color", new ColorEntity());

        return "redirect:/listColor";
    }

    @RequestMapping(value = "/deleteColor/{colorId}", method = RequestMethod.GET)
    public String deleteColor(@PathVariable(value = "colorId") int colorId, Model model) {

        try {
            colorRepo.deleteById(colorId);
            List<ColorEntity> colorList = (List<ColorEntity>) colorRepo.findAll();
            model.addAttribute("colorList", colorList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/listColor";
    }

    @RequestMapping(value = "/viewColor/{id}", method = RequestMethod.GET)
    public String getListProductfindColor(@PathVariable(value = "id") int id, Model model, HttpSession session) {

        List<ProductDetailsEntity> colorList = (List<ProductDetailsEntity>) productDetailsRepo.getColorfindProductDetails(id);
        model.addAttribute("colorList", colorList);
        return "admin/viewColor";
    }
}
