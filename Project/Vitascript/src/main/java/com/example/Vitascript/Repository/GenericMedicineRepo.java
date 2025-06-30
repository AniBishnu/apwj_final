package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
class GenericMedicineRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM generic_medicine";
    public String GetById = "SELECT * FROM generic_medicine WHERE id=?";
    public String AddOne = "INSERT INTO generic_medicine (name, formula) VALUES (?, ?)";
    public String Update = "UPDATE generic_medicine SET name=?, formula=? WHERE id=?";
    public String SearchByName = "SELECT * FROM generic_medicine WHERE name LIKE ?";

    public GenericMedicineRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<GenericMedicine> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(GenericMedicine.class));
    }

    public GenericMedicine getById(int id) {
        return jdbc.queryForObject(GetById, new Object[]{id}, new BeanPropertyRowMapper<>(GenericMedicine.class));
    }

    public void add(GenericMedicine med) {
        jdbc.update(AddOne, med.getName(), med.getFormula());
    }

    public void update(GenericMedicine med) {
        jdbc.update(Update, med.getName(), med.getFormula(), med.getId());
    }

    public List<GenericMedicine> searchByName(String name) {
        return jdbc.query(SearchByName, new Object[]{"%" + name + "%"}, new BeanPropertyRowMapper<>(GenericMedicine.class));
    }
}
