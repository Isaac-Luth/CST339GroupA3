package com.groupa3.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupa3.dao.DataAccessObject;
import com.groupa3.dto.TaskDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TaskRestService
 */
@RestController
@RequestMapping("/service")
public class TaskRestService {
    
    @Autowired
    private DataAccessObject dataAccessObject;

    
    /** 
     *  Get all tasks
     * @return List TaskDto A list of all tasks
     */
    @GetMapping(path = "/getalltasks", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<TaskDto> getAllTasks() {
        return dataAccessObject.getTasks();
    }

    
    /** 
     *  Get a task by id
     * @param id The id of the task to get
     * @return ResponseEntity ? The task with the given id
     */
    @GetMapping(path = "/gettask/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getTask(@PathVariable("id") Long id) {
        try {
            TaskDto task = dataAccessObject.getTask(id);
            
            if (task == null)
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
