package com.shopme.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Spring MVC controller class
/*Controllers provide access to the application behavior that you typically define through a service interface.
Controllers interpret user input and transform it into a model that is represented to the user by the view.

 in Spring MVC, we write a controller class to handle requests coming from the client. Then, the controller invokes a business class(service)
  to process business-related tasks,*/
public class MainController {

    @GetMapping("") //handle http get request to the homepage
    public String viewHomePage(){
        return "index"; //index.html in templates
    }
}
