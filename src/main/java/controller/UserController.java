/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.UserEntity;
import entity.UserRoleEntity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.UserRepository;
import repository.UserRoleRepository;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserRoleRepository userRoleRepo;

    //---User---//
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String showUser(Model model) {
        List<UserEntity> userList = (List<UserEntity>) userRepo.findAll();
        model.addAttribute("userList", userList);

        return "admin/listUser";
    }

    @RequestMapping(value = "/editUser/{userId}", method = RequestMethod.GET)
    public String showUpdateUser(@PathVariable(value = "userId") int userId, Model model) {
        UserEntity user = userRepo.findByUserId(userId);
        model.addAttribute("user", user);

        setUserDropdownList(model);

        return "admin/editUser";
    }

    private void setUserDropdownList(Model model) {
        List<UserRoleEntity> userRoleList = (List<UserRoleEntity>) userRoleRepo.findAll();
        if (!userRoleList.isEmpty()) {
            Map<Integer, String> user_rolesMap = new LinkedHashMap<>();

            for (UserRoleEntity user_roles : userRoleList) {
                user_rolesMap.put(user_roles.getUserRoleId(), user_roles.getRole());
            }
            model.addAttribute("userRoleList", user_rolesMap);
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(UserEntity user, Model model) {

        userRepo.save(user);

        return "redirect:/listUser";
    }

    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "userId") int userId, Model model) {

        try {
            userRepo.deleteById(userId);
        } catch (Exception e) {
            System.out.println(e);
        }
        List<UserEntity> userList = (List<UserEntity>) userRepo.findAll();

        return "redirect:/listUser";
    }

}
