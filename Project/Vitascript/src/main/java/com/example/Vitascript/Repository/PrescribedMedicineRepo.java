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
    public String AddOne = "INSERT INTO prescribed_medicine (prescription_id, generic_medicine_id, dose, duration, notes, quantity,quantityLeft) VALUES (?, ?, ?, ?, ?, ?,?)";
    public String Upd2 = "UPDATE prescribed_medicine SET quantity_left = quantity_left - ? WHERE prescription_id = ? AND generic_medicine_id = ? AND quantity_left >= ?";
    public String Upd3 = "SELECT COUNT(*) FROM prescribed_medicine WHERE prescription_id = ? AND generic_medicine_id = ?";

    public PrescribedMedicineRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<PrescribedMedicine> getByPrescriptionId(int prescriptionId) {
        return jdbc.query(GetByPrescription, new Object[]{prescriptionId}, new BeanPropertyRowMapper<>(PrescribedMedicine.class));
    }

    public void add(PrescribedMedicine pm) {
        jdbc.update(AddOne, pm.getPrescriptionId(), pm.getGenericMedicineId(), pm.getDose(), pm.getDuration(), pm.getNotes(), pm.getQuantity(),pm.getQuantityLeft());
    }

    public void decreaseQuantityLeft(int prescriptionId, int genericMedicineId, int quantityToReduce) {
        int updated = jdbc.update(Upd2, quantityToReduce, prescriptionId, genericMedicineId, quantityToReduce);

        if (updated == 0) {
            throw new RuntimeException("Cannot reduce prescribed quantity — not enough quantityLeft or prescription mismatch.");
        }
    }

    public boolean isGenericPrescribed(int prescriptionId, int genericMedicineId) {
        Integer count = jdbc.queryForObject(Upd3, new Object[]{prescriptionId, genericMedicineId}, Integer.class);
        return count != null && count > 0;
    }

}
