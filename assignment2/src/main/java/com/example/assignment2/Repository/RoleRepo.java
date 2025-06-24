package com.example.assignment2.Repository;
import com.example.assignment2.Entity.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoleRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM role";
    public String GetOne = "SELECT * FROM role WHERE id=?";

    public RoleRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Role> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Role.class));
    }

    public Role getById(int id) {
        return jdbc.queryForObject(GetOne, new Object[]{id}, new BeanPropertyRowMapper<>(Role.class));
    }
}
