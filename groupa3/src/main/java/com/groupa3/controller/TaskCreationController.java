package com.groupa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupa3.dao.DataAccessObject;
import com.groupa3.dto.TaskDto;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/createTask")
public class TaskCreationController {

    @Autowired
    private DataAccessObject dataAccessObject;

    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskDto taskDto) {

        dataAccessObject.createTask(taskDto);

        return "redirect:/createTask?success";
    }

    @RequestMapping("/cancel")
    public String cancelCreateTask(@ModelAttribute TaskDto taskDto) {
        return "menu";
    }

    @GetMapping
    public String createTaskSuccess() {
        return "menu";
    }
}
