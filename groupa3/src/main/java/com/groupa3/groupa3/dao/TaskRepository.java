package com.groupa3.groupa3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.groupa3.groupa3.dto.TaskDto;

@SuppressWarnings("null")
@Repository
public class TaskRepository implements TaskRepositoryInterface {

    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public TaskRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @SuppressWarnings("unchecked")
    @Override
    public TaskDto save(TaskDto taskDto) {
        String sql = "INSERT INTO task (Name, Description, Duration) VALUES (?, ?, ?)";
        TaskDto savedTaskDto = new TaskDto();

        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setObject(1, taskDto.getName());
            pstmt.setObject(2, taskDto.getDescription());
            pstmt.setObject(3, taskDto.getManHoursExpected());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return savedTaskDto;
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
