
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.OrderDetailsEntity;
import entity.OrdersEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.OrderDetailsRepository;
import repository.OrdersRepository;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/")
public class OrderController {

    @Autowired
    OrdersRepository orderRepo;

    @Autowired
    OrderDetailsRepository orderDetailsRepo;

    //---Order---//
    @RequestMapping(value = "/listOrder", method = RequestMethod.GET)
    public String showOrder(Model model) {
        List<OrdersEntity> orderList = (List<OrdersEntity>) orderRepo.getAllOrder1();
        model.addAttribute("orderList", orderList);

        return "admin/listOrder";
    }

    @RequestMapping(value = "/deleteOrder/{orderId}", method = RequestMethod.GET)
    public String deleteOrder(@PathVariable(value = "orderId") int orderId, Model model) {

        try {
            orderRepo.deleteById(orderId);
            List<OrdersEntity> orderList = (List<OrdersEntity>) orderRepo.findAll();
            model.addAttribute("orderList", orderList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/listOrder";
    }

    @RequestMapping(value = "/viewOrderDetails/{id}", method = RequestMethod.GET)
    public String viewOrderDetails(@PathVariable(value = "id") int id, Model model) {

        List<OrderDetailsEntity> orderList = (List<OrderDetailsEntity>) orderDetailsRepo.getOrderDetailsfindOrders(id);
        model.addAttribute("orderList", orderList);
        return "admin/viewOrderDetails";
    }

    //---Order Details---//
    @RequestMapping(value = "/listOrderDetails", method = RequestMethod.GET)
    public String showOrderDetails(Model model) {
        List<OrderDetailsEntity> orderDetailsList = (List<OrderDetailsEntity>) orderDetailsRepo.findAll();
        model.addAttribute("orderDetailsList", orderDetailsList);

        return "admin/listOrderDetails";
    }

    
    //--Phan Trang Order--//

    @RequestMapping(value = "/view-all-order/{pageOrderId}", method = RequestMethod.GET)
    public String showAllOrder(@PathVariable int pageOrderId, Model model) {

        int countOrder = orderRepo.getCountOrder();
        int limitOrder = 10;
        if (pageOrderId == 1) {
        } else {
            pageOrderId = (pageOrderId - 1) * limitOrder + 1;
        }
        List<OrdersEntity> orderList = orderRepo.getAllOrder((pageOrderId - 1), limitOrder);

        model.addAttribute("orderList", orderList);
        model.addAttribute("countOrder", countOrder);

        return "admin/listOrder";
    }
    
}
