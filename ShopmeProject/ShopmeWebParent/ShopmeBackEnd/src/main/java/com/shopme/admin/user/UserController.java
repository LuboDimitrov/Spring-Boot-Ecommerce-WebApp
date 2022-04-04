package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//This class will handle the requests for the user module

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

    @GetMapping("/users/new")
    public String newUser(Model model) {
        //retrieve a list of roles and put it onto the model
        List<Role> listRoles = service.listRoles();
        User user = new User();
        user.setEnabled(true); //true by default
        model.addAttribute("user", user);
        //we put it onto the model so it will be available in the user form
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }

    @PostMapping("/users/save")
    //redirect attributes to show the successful message
    public String saveUser(User user, RedirectAttributes redirectAttributes){
        System.out.println(user);//for testing purposes
        service.saveUser(user);

        redirectAttributes.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/users";
    }


}
