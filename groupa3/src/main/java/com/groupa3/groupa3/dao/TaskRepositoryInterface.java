package com.groupa3.groupa3.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.groupa3.groupa3.dto.TaskDto;

@Repository
public interface TaskRepositoryInterface extends CrudRepository<TaskDto, Long> {
    public boolean updateTask(TaskDto taskDto);
}