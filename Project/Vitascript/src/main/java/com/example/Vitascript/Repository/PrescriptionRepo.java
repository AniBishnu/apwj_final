package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PrescriptionRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM prescription";
    public String GetById = "SELECT * FROM prescription WHERE id=?";
    public String GetByDoctor = "SELECT * FROM prescription WHERE doctor_id=?";
    public String GetByCode = "SELECT * FROM prescription WHERE code=?";
    public String AddOne = "INSERT INTO prescription (code, doctor_id, patient_id, appointment_id, status, issued_date) VALUES (?, ?, ?, ?, ?, ?)";

    public PrescriptionRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Prescription> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Prescription.class));
    }

    public Prescription getById(int id) {
        return jdbc.queryForObject(GetById, new Object[]{id}, new BeanPropertyRowMapper<>(Prescription.class));
    }

    public List<Prescription> getByDoctor(int doctorId) {
        return jdbc.query(GetByDoctor, new Object[]{doctorId}, new BeanPropertyRowMapper<>(Prescription.class));
    }

    public Prescription getByCode(String code) {
        return jdbc.queryForObject(GetByCode, new Object[]{code}, new BeanPropertyRowMapper<>(Prescription.class));
    }

    public void add(Prescription prescription) {
        jdbc.update(AddOne,
                prescription.getCode(),
                prescription.getDoctorId(),
                prescription.getPatientId(),
                prescription.getAppointmentId(),
                prescription.getStatus().toString(),
                prescription.getIssuedDate()
        );
    }
}