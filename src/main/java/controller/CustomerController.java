/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.CustomerEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.CustomerRepository;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepo;

    //---Customer--//
    @RequestMapping(value = "/listCustomer", method = RequestMethod.GET)
    public String showCustomer(Model model) {
        List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepo.findAll();
        model.addAttribute("customerList", customerList);

        return "admin/listCustomer";
    }

    @RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable(value = "customerId") int customerId, Model model) {

        try {
            customerRepo.deleteById(customerId);
            List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepo.findAll();
            model.addAttribute("customerList", customerList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/listCustomer";
    }

    @RequestMapping(value = "/editCustomer/{customerId}", method = RequestMethod.GET)
    public String showEditCustomer(@PathVariable(value = "customerId") int customerId, Model model) {
        CustomerEntity customer = customerRepo.findByCustomerId(customerId);

        model.addAttribute("customer", customer);

        String[] sex1 = {"Male", "Female"};

        model.addAttribute("sex1", sex1);

        return "admin/editCustomer";
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(CustomerEntity customer, Model model) {

        customerRepo.save(customer);

        return "redirect:/listCustomer";
    }

}
