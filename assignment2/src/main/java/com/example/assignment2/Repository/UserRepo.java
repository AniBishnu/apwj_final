package com.example.assignment2.Repository;

import com.example.assignment2.Entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepo {

    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM user";
    public String GetByUsername = "SELECT * FROM user WHERE username=?";
    public String AddOne = "INSERT INTO user (username, password, email, role_id) VALUES (?, ?, ?, ?)";

    public UserRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<User> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(User.class));
    }

    public User getByUsername(String username) {
        return jdbc.queryForObject(GetByUsername, new Object[]{username}, new BeanPropertyRowMapper<>(User.class));
    }

    public void addUser(User user) {
        jdbc.update(AddOne,
                user.username,
                user.password,
                user.email,
                user.role_id
        );
    }
}