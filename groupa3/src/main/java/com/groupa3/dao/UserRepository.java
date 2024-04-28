package com.groupa3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupa3.dao.UserRepository;
import com.groupa3.dto.UserDto;

/**
 * Repository for the user
 */
@SuppressWarnings("null")
@Repository
public class UserRepository implements UserRepositoryInterface {

    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor for the user repository
     * @param dataSource The data source
     */
    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    
    /** 
     *  Finds a user by username
     * @param username The username to find
     * @return UserDto The user with the given username
     */
    @Override
    public UserDto findByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        UserDto userDto = new UserDto();

        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setObject(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getBoolean("IsActive") == false) {
                    return userDto;
                }

                userDto.setId(rs.getLong("idUser"));
                userDto.setUsername(rs.getString("Username"));
                userDto.setEmail(rs.getString("Email"));
                userDto.setPassword(rs.getString("Password"));
                userDto.setFirstname(rs.getString("FirstName"));
                userDto.setLastname(rs.getString("LastName"));
                userDto.setTelephone(rs.getString("PhoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userDto;
    }

    
    /** 
     *  Finds a user by email
     * @param email The email to find
     * @return UserDto The user with the given email
     */
    @Override
    public UserDto findByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        UserDto userDto = new UserDto();

        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setObject(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getBoolean("IsActive") == false) {
                    return userDto;
                }

                userDto.setId(rs.getLong("idUser"));
                userDto.setUsername(rs.getString("Username"));
                userDto.setEmail(rs.getString("Email"));
                userDto.setPassword(rs.getString("Password"));
                userDto.setFirstname(rs.getString("FirstName"));
                userDto.setLastname(rs.getString("LastName"));
                userDto.setTelephone(rs.getString("PhoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userDto;
    }

    
    /** 
     *  Finds a user by id
     * @param id The id to find
     * @return Optional UserDto The user with the given id
     */
    @Override
    public Optional<UserDto> findById(Long id) {
        String sql = "SELECT * FROM user WHERE idUser = ?";
        UserDto userDto = new UserDto();

        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setObject(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getBoolean("IsActive") == false) {
                    return Optional.of(userDto);
                }

                userDto.setId(rs.getLong("idUser"));
                userDto.setUsername(rs.getString("Username"));
                userDto.setEmail(rs.getString("Email"));
                userDto.setPassword(rs.getString("Password"));
                userDto.setFirstname(rs.getString("FirstName"));
                userDto.setLastname(rs.getString("LastName"));
                userDto.setTelephone(rs.getString("PhoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.of(userDto);
    }

    
    /** 
     *  Finds the number of users
     * @return long The number of users
     */
    @Override
    public long count() {
        String sql = "SELECT COUNT(*) FROM user";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    
    /** 
     *  Deletes a user
     * @param entity The user to delete
     */
    @Override
    public void delete(UserDto entity) {
        String sql = "DELETE FROM user WHERE idUser = ?";
        jdbcTemplate.update(sql, entity.getId());
    }

    /**
     * Delete all users
     */
    @Override
    public void deleteAll() {
        String sql = "DELETE FROM user";
        jdbcTemplate.update(sql);
    }

    
    /** 
     *  Deletes all users
     * @param entities The users to delete
     */
    @Override
    public void deleteAll(Iterable<? extends UserDto> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    
    /** 
     *  Deletes all users by id
     * @param ids The ids of the users to delete
     */
    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    
    /** 
     *  Deletes a user by id
     * @param id The id of the user to delete
     */
    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM user WHERE idUser = ?";
        jdbcTemplate.update(sql, id);
    }

    
    /** 
     *  Checks if a user exists by id
     * @param id The id to check
     * @return boolean Whether the user exists
     */
    @SuppressWarnings("deprecation")
    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM user WHERE idUser = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
        return count != null && count > 0;
    }

    
    /** 
     *  Finds all users
     * @return Iterable UserDto All users
     */
    @Override
    public Iterable<UserDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    
    /** 
     *  Finds all users by id
     * @param ids The ids of the users to find
     * @return Iterable UserDto The users with the given ids
     */
    @Override
    public Iterable<UserDto> findAllById(Iterable<Long> ids) {
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    
    /** 
     *  Saves a user
     * @param entity The user to save
     * @return S The saved user
     */
    @Override
    public <S extends UserDto> S save(S entity) {
        String sql = "INSERT INTO user (Username, Email, Password, FirstName, LastName, PhoneNumber) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
            pstmt.setString(1, entity.getUsername());
            pstmt.setString(2, entity.getEmail());
            pstmt.setString(3, entity.getPassword());
            pstmt.setString(4, entity.getFirstname());
            pstmt.setString(5, entity.getLastname());
            pstmt.setString(6, entity.getTelephone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    
    /** 
     *  Saves all users
     * @param entities The users to save
     * @return Iterable S The saved users
     */
    @Override
    public <S extends UserDto> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    
    /** 
     *  Finds a user by id
     * @param id The id of the user to find
     * @return UserDto The user with the given id
     */
    @Override
    public UserDto findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
    /** 
     *  Authenticates a user
     * @param username The username to check
     * @return boolean Whether the user exists
     */
    @SuppressWarnings("deprecation")
    @Override
    public boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE Username = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        return count != null && count > 0;
    }
}