package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BrandedMedicineRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM branded_medicine";
    public String GetByGenericId = "SELECT * FROM branded_medicine WHERE generic_medicine_id=?";
    public String AddOne = "INSERT INTO branded_medicine (name, generic_medicine_id, brand_name, buying_price, mrp) VALUES (?, ?, ?, ?, ?)";
    public String Update = "UPDATE branded_medicine SET name=?, brand_name=?, buying_price=?, mrp=? WHERE id=?";

    public BrandedMedicineRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<BrandedMedicine> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(BrandedMedicine.class));
    }

    public List<BrandedMedicine> getByGenericId(int genericId) {
        return jdbc.query(GetByGenericId, new Object[]{genericId}, new BeanPropertyRowMapper<>(BrandedMedicine.class));
    }

    public void add(BrandedMedicine bm) {
        jdbc.update(AddOne, bm.getName(), bm.getGenericMedicineId(), bm.getBrandName(), bm.getBuyingPrice(), bm.getMrp());
    }

    public void update(BrandedMedicine bm) {
        jdbc.update(Update, bm.getName(), bm.getBrandName(), bm.getBuyingPrice(), bm.getMrp(), bm.getId());
    }
}
