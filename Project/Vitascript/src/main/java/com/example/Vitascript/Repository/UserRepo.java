package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepo {

    private final JdbcTemplate jdbc;

    private final String GetAll = "SELECT * FROM user";
    private final String GetByEmail = "SELECT * FROM user WHERE email=?";
    private final String AddOne = "INSERT INTO user (name, password, phone, email, address, dob, role, created_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UpdateOne = "UPDATE user SET name=?, phone=?, email=?, address=?, dob=? WHERE id=? AND role='PATIENT'";

    public UserRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<User> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(User.class));
    }

    public User getByEmail(String email) {
        return jdbc.queryForObject(GetByEmail, new Object[]{email}, new BeanPropertyRowMapper<>(User.class));
    }

    public void addUser(User user) {
        jdbc.update(AddOne,
                user.getName(),
                user.getPassword(),
                user.getPhone(),
                user.getEmail(),
                user.getAddress(),
                user.getDob(),
                user.getRole().toString(),
                user.getCreatedTime()
        );
    }

    public void updateUser(User user) {
        jdbc.update(UpdateOne,
                user.getName(),
                user.getPhone(),
                user.getEmail(),
                user.getAddress(),
                user.getDob(),
                user.getId()
        );
    }

}
