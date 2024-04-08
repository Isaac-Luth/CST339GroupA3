package com.groupa3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupa3.dao.DataAccessObject;
import com.groupa3.dto.TaskDto;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/projectCalender")
public class ProjectCalenderController {

    @Autowired
    private DataAccessObject dataAccessObject;

    @GetMapping("/view")
    public String viewTasks(Model model) {

        List<TaskDto> tasks = dataAccessObject.getTasks();
        
        model.addAttribute("tasks", tasks);

        return "projectCalender";
    }

    @RequestMapping("/editTask/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {

        TaskDto task = dataAccessObject.getTask(id);

        model.addAttribute("task", task);

        return "taskEdit";
    }

    @PostMapping("/comfirmEdit")
    public String comfirmEdit(@ModelAttribute TaskDto taskDto) {

        dataAccessObject.updateTask(taskDto);

        return "redirect:/projectCalender/view";
    }

    @PostMapping("/delete")
    public String deleteTask(@ModelAttribute TaskDto taskDto) {

        dataAccessObject.deleteTask(taskDto.getId());

        return "redirect:/projectCalender/view";
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
