package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SaleRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM sale";
    public String GetByPharmacy = "SELECT * FROM sale WHERE pharmacy_id=?";
    public String AddOne = "INSERT INTO sale (prescription_id, pharmacy_id, date, total_amount) VALUES (?, ?, ?, ?)";

    public SaleRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Sale> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Sale.class));
    }

    public List<Sale> getByPharmacy(int pharmacyId) {
        return jdbc.query(GetByPharmacy, new Object[]{pharmacyId}, new BeanPropertyRowMapper<>(Sale.class));
    }

    public void add(Sale sale) {
        jdbc.update(AddOne, sale.getPrescriptionId(), sale.getPharmacyId(), sale.getDate(), sale.getTotalAmount());
    }
}
