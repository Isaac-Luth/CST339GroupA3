package com.groupa3.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.groupa3.dto.TaskDto;

/**
 * Interface for the task repository
 */
@Repository
public interface TaskRepositoryInterface extends CrudRepository<TaskDto, Long> {
    /**
     * Find a task by id
     * @param taskDto The task to find
     * @return TaskDto The task with the given id
     */
    public boolean updateTask(TaskDto taskDto);
}