package com.groupa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupa3.dao.DataAccessObject;
import com.groupa3.dto.TaskDto;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for creating a task
 */
@Controller
@RequestMapping("/createTask")
public class TaskCreationController {

    @Autowired
    private DataAccessObject dataAccessObject;

    
    /** 
     * @param taskDto The task to create
     * @return String The name of the view to display
     */
    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskDto taskDto) {

        dataAccessObject.createTask(taskDto);

        return "redirect:/createTask?success";
    }

    
    /** 
     * @param taskDto The task to cancel
     * @return String The name of the view to display
     */
    @RequestMapping("/cancel")
    public String cancelCreateTask(@ModelAttribute TaskDto taskDto) {
        return "menu";
    }

    
    /** 
     * @return String The name of the view to display
     */
    @GetMapping
    public String createTaskSuccess() {
        return "menu";
    }
}
