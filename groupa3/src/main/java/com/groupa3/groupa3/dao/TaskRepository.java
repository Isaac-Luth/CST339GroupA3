package com.groupa3.groupa3.dao;

import org.springframework.data.repository.CrudRepository;

import com.groupa3.groupa3.dto.TaskDto;

public interface TaskRepository extends CrudRepository<TaskDto, Long> {

}