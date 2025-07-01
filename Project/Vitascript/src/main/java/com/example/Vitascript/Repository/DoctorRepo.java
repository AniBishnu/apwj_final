package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DoctorRepo {
    private final JdbcTemplate jdbc;

    private final String GetAll = "SELECT * FROM doctor";
    private final String GetById = "SELECT * FROM doctor WHERE id=?";
    private final String AddOne = "INSERT INTO doctor (user_id, doctor_type, license_number) VALUES (?, ?, ?)";
    private final String Update = "UPDATE doctor SET doctor_type=?, license_number=? WHERE id=?";
    private final String Delete = "DELETE FROM doctor WHERE id=?";

    public DoctorRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Doctor> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Doctor.class));
    }

    public Doctor getById(int id) {
        return jdbc.queryForObject(GetById, new Object[]{id}, new BeanPropertyRowMapper<>(Doctor.class));
    }

    public void addDoctor(Doctor doctor) {
        jdbc.update(AddOne, doctor.getUserId(), doctor.getDoctorTypeId(), doctor.getLicenseNumber());
    }

    public void updateDoctor(Doctor doctor) {
        jdbc.update(Update, doctor.getDoctorTypeId(), doctor.getLicenseNumber(), doctor.getId());
    }

    public void deleteDoctor(int id) {
        jdbc.update(Delete, id);
    }
}
