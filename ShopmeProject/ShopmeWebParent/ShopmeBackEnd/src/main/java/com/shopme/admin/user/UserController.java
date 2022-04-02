package com.shopme.admin.user;

import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//This class will handle requests for the user module

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    //Model-> to have access to Spring MVC model
    public String listAll(Model model) {
        List<User> listUsers = service.listAll();
        //we put the list onto the model
        model.addAttribute("listUsers", listUsers);
        return "users"; //users.html
    }

}
