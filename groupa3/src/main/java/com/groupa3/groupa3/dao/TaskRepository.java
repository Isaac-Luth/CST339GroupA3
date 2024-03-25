package com.groupa3.groupa3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.groupa3.groupa3.dto.TaskDto;

@SuppressWarnings("null")
@Repository
public class TaskRepository implements TaskRepositoryInterface{

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
        
        String sql = "SELECT * FROM task WHERE idTask = ?";
        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setObject(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                taskDto.setId(rs.getLong("idTask"));
                taskDto.setName(rs.getString("Name"));
                taskDto.setDescription(rs.getString("Description"));
                taskDto.setManHoursExpected(rs.getDouble("Duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Optional.of(taskDto);
    }

    public boolean updateTask(TaskDto taskDto) {
        boolean taskUpdated = false;

        String sql = "UPDATE task SET Name = ?, Description = ?, Duration = ? WHERE idTask = ?";

        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setObject(1, taskDto.getName());
            pstmt.setObject(2, taskDto.getDescription());
            pstmt.setObject(3, taskDto.getManHoursExpected());
            pstmt.setObject(4, taskDto.getId());
            pstmt.executeUpdate();
            taskUpdated = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskUpdated;
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
        String sql = "DELETE FROM task WHERE idTask = ?";
        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setObject(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Iterable<TaskDto> findAll() {
        String sql = "SELECT * FROM task";

        List<TaskDto> taskList = new ArrayList<TaskDto>();

        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                TaskDto taskDto = new TaskDto();
                taskDto.setId(rs.getLong("idTask"));
                taskDto.setName(rs.getString("Name"));
                taskDto.setDescription(rs.getString("Description"));
                taskDto.setManHoursExpected(rs.getDouble("Duration"));
                taskList.add(taskDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskList;
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
