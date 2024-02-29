package com.groupa3.groupa3.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.groupa3.groupa3.dto.TaskDto;

@Repository
public class TaskRepository implements TaskRepositoryInterface {

    @Override
    public TaskDto save(TaskDto taskDto) {
        // Implement logic to save taskDto to the database
        // This is just a dummy implementation
        taskDto.setId(1L); // Assigning a dummy ID for illustration
        return taskDto;
    }

    @Override
    public Optional<TaskDto> findById(Long id) {
        // Implement logic to find task by id in the database
        // This is just a dummy implementation
        TaskDto taskDto = new TaskDto();
        taskDto.setId(id);
        taskDto.setName("Example Task");
        // Add more properties as needed
        return Optional.of(taskDto);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void delete(TaskDto entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll(Iterable<? extends TaskDto> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Iterable<TaskDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Iterable<TaskDto> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public <S extends TaskDto> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    // Implement other methods defined in TaskRepository interface
    // such as delete(), findAll(), etc.
}
