package com.groupa3.groupa3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.groupa3.groupa3.dao.UserRepository;
import com.groupa3.groupa3.dto.UserDto;

@SuppressWarnings("null")
@Repository
public class UserRepository implements UserRepositoryInterface {

    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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

    @Override
    public long count() {
        String sql = "SELECT COUNT(*) FROM user";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    @Override
    public void delete(UserDto entity) {
        String sql = "DELETE FROM user WHERE idUser = ?";
        jdbcTemplate.update(sql, entity.getId());
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM user";
        jdbcTemplate.update(sql);
    }

    @Override
    public void deleteAll(Iterable<? extends UserDto> entities) {
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
        String sql = "DELETE FROM user WHERE idUser = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM user WHERE idUser = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public Iterable<UserDto> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Iterable<UserDto> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

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
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public <S extends UserDto> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public UserDto findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE Username = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        return count != null && count > 0;
    }

    // Implement other methods defined in UserRepository interface
    // such as save(), delete(), findAll(), etc.
}