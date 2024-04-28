package com.groupa3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Controller for the login page
 */
@Controller
public class LoginController {

    
    /** 
     * @param model The model to add attributes to
     * @return String The name of the view to display
     */
    @GetMapping("/login")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        return "login";
    }
    

}