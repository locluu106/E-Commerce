
package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.OrdersRepository;

@Controller
@RequestMapping(value = "/")
public class AdminController {
  
    @Autowired
    OrdersRepository orderRepo;
    
    @RequestMapping(value = "/admin/showHomeAdmin", method = RequestMethod.GET)
    public String showAllHome(Model model) {

        return "admin";
    }

   

    
}
