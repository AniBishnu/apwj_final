package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PrescribedMedicineRepo {
    public JdbcTemplate jdbc;

    public String GetByPrescription = "SELECT * FROM prescribed_medicine WHERE prescription_id=?";
    public String AddOne = "INSERT INTO prescribed_medicine (prescription_id, generic_medicine_id, dose, duration, notes, quantity) VALUES (?, ?, ?, ?, ?, ?)";

    public PrescribedMedicineRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<PrescribedMedicine> getByPrescriptionId(int prescriptionId) {
        return jdbc.query(GetByPrescription, new Object[]{prescriptionId}, new BeanPropertyRowMapper<>(PrescribedMedicine.class));
    }

    public void add(PrescribedMedicine pm) {
        jdbc.update(AddOne, pm.getPrescriptionId(), pm.getGenericMedicineId(), pm.getDose(), pm.getDuration(), pm.getNotes(), pm.getQuantity());
    }
}
