package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PharmacyRepo {
    private final JdbcTemplate jdbc;

    private final String GetAll = "SELECT * FROM pharmacy";
    private final String GetById = "SELECT * FROM pharmacy WHERE id=?";
    private final String GetByUserId = "SELECT * FROM pharmacy WHERE user_id=?";
    private final String AddOne = "INSERT INTO pharmacy (user_id, pharmacy_name, license_number, location) VALUES (?, ?, ?, ?)";
    private final String Update = "UPDATE pharmacy SET pharmacy_name=?, license_number=?, location=? WHERE id=?";
    private final String Delete = "DELETE FROM pharmacy WHERE id=?";

    public PharmacyRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Pharmacy> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Pharmacy.class));
    }

    public Pharmacy getById(int id) {
        return jdbc.queryForObject(GetById, new Object[]{id}, new BeanPropertyRowMapper<>(Pharmacy.class));
    }

    public Pharmacy getByUserId(int userId) {
        return jdbc.queryForObject(GetByUserId, new Object[]{userId}, new BeanPropertyRowMapper<>(Pharmacy.class));
    }

    public void addPharmacy(Pharmacy pharmacy) {
        jdbc.update(AddOne, pharmacy.getUserId(), pharmacy.getPharmacyName(), pharmacy.getLicenseNumber(), pharmacy.getLocation());
    }

    public void updatePharmacy(Pharmacy pharmacy) {
        jdbc.update(Update, pharmacy.getPharmacyName(), pharmacy.getLicenseNumber(), pharmacy.getLocation(), pharmacy.getId());
    }

    public void deletePharmacy(int id) {
        jdbc.update(Delete, id);
    }
}