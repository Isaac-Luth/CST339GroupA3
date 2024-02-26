package com.groupa3.groupa3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("menu")
    public String menu() {
        return "menu";
    }

    @RequestMapping("taskCreation")
    public String createTask() {
        return "taskCreation";
    }

}
