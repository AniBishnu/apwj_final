package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AppointmentRepo {
    public JdbcTemplate jdbc;

    public String GetByDoctor = "SELECT * FROM appointment WHERE doctor_id=?";
    public String AddOne = "INSERT INTO appointment (patient_name, patient_age, patient_gender, patient_phone, doctor_id, patient_id, apointment_taken) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public AppointmentRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Appointment> getByDoctor(int doctorId) {
        return jdbc.query(GetByDoctor, new Object[]{doctorId}, new BeanPropertyRowMapper<>(Appointment.class));
    }

    public void add(Appointment appointment) {
        jdbc.update(AddOne, appointment.getPatientName(), appointment.getPatientAge(), appointment.getPatientGender(), appointment.getPatientPhone(), appointment.getDoctorId(), appointment.getPatientId(), appointment.getApointmentTaken());
    }
}
