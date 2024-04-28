package com.groupa3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupa3.dto.TaskDto;

/**
 * Repository for the task
 */
@Repository
public class TaskRepository implements TaskRepositoryInterface{

    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor for the task repository
     * @param dataSource The data source
     */
    public TaskRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    
    /** 
     *  Saves a task
     * @param taskDto The task to save
     * @return TaskDto The saved task
     */
    @SuppressWarnings({ "unchecked", "null" })
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

    
    /** 
     *  Finds a task by id
     * @param id The id of the task to find
     * @return Optional TaskDto The task with the given id
     */
    @SuppressWarnings("null")
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

    
    /** 
     *  Updates a task
     * @param taskDto The task to update
     * @return boolean Whether the task was updated
     */
    @SuppressWarnings("null")
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

    
    /** 
     *  Counts the number of tasks
     * @return long The number of tasks
     */
    @SuppressWarnings("null")
    @Override
    public long count() {
        String sql = "SELECT COUNT(*) FROM task";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    
    /** 
     *  Deletes a task
     * @param entity The task to delete
     */
    @SuppressWarnings("null")
    @Override
    public void delete(TaskDto entity) {
        String sql = "DELETE FROM task WHERE idTask = ?";
        jdbcTemplate.update(sql, entity.getId());
    }

    /**
     * Delete all tasks
     */
    @Override
    public void deleteAll() {
        String sql = "DELETE FROM task";
        jdbcTemplate.update(sql);
    }

    
    /** 
     *  Deletes all tasks
     * @param entities The tasks to delete
     */
    @SuppressWarnings("null")
    @Override
    public void deleteAll(Iterable<? extends TaskDto> entities) {
        String sql = "DELETE FROM task WHERE idTask = ?";
        List<Object[]> ids = new ArrayList<>();
        entities.forEach(task -> ids.add(new Object[]{task.getId()}));
        jdbcTemplate.batchUpdate(sql, ids);
    }

    
    /** 
     *  Deletes all tasks by id
     * @param ids The ids of the tasks to delete
     */
    @SuppressWarnings("null")
    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        String sql = "DELETE FROM task WHERE idTask = ?";
        List<Object[]> idList = new ArrayList<>();
        ids.forEach(id -> idList.add(new Object[]{id}));
        jdbcTemplate.batchUpdate(sql, idList);
    }

    
    /** 
     *  Deletes a task by id
     * @param id The id of the task to delete
     */
    @SuppressWarnings("null")
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

    
    /** 
     *  Checks if a task exists by id
     * @param id The id of the task to find
     * @return boolean Whether the task exists
     */
    @SuppressWarnings({ "deprecation", "null" })
    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM task WHERE idTask = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
        return count != null && count > 0;
    }

    
    /** 
     *  Finds all tasks
     * @return Iterable TaskDto All tasks
     */
    @SuppressWarnings("null")
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

    
    /** 
     *  Finds all tasks by id
     * @param ids The ids of the tasks to find
     * @return Iterable TaskDto The tasks with the given ids
     */
    @SuppressWarnings("null")
    @Override
    public Iterable<TaskDto> findAllById(Iterable<Long> ids) {
        List<TaskDto> tasks = new ArrayList<>();
        ids.forEach(id -> findById(id).ifPresent(tasks::add));
        return tasks;
    }

    
    /** 
     *  Saves a task
     * @param entities The tasks to save
     * @return Iterable S The saved tasks
     */
    @SuppressWarnings("null")
    @Override
    public <S extends TaskDto> Iterable<S> saveAll(Iterable<S> entities) {
        String sql = "INSERT INTO task (idTask, Name, Description, Duration) VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE Name = VALUES(Name), Description = VALUES(Description), Duration = VALUES(Duration)";
        List<Object[]> batchArgs = new ArrayList<>();
        entities.forEach(task -> batchArgs.add(new Object[]{task.getId(), task.getName(), task.getDescription(), task.getManHoursExpected()}));
        jdbcTemplate.batchUpdate(sql, batchArgs);
        return entities;
    }

}
