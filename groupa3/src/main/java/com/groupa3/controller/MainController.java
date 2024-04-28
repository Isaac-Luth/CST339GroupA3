package com.groupa3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the main page
 */
@Controller
public class MainController {

    
    /** 
     *  Display the home page
     * @param model The model to add attributes to
     * @return String The name of the view to display
     */
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "My Home");
        return "index";
    }

    
    /** 
     *  Display the login page
     * @return String The name of the view to display
     */
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    
    /** 
     *  Display the login page
     * @return String The name of the view to display
     */
    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    
    /** 
     *  Display the login page
     * @return String The name of the view to display
     */
    @GetMapping("/taskCreation")
    public String createTask() {
        return "taskCreation";
    }

}
