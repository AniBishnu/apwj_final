package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SaleItemRepo {
    public JdbcTemplate jdbc;

    public String GetBySale = "SELECT * FROM sale_item WHERE sale_id=?";
    public String AddOne = "INSERT INTO sale_item (sale_id, branded_medicine_id, quantity, unit_price) VALUES (?, ?, ?, ?)";
    public String getAll="SELECT * FROM sale_item";
    public SaleItemRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<SaleItem> getBySale(int saleId) {
        return jdbc.query(GetBySale, new Object[]{saleId}, new BeanPropertyRowMapper<>(SaleItem.class));
    }

    public void add(SaleItem item) {
        jdbc.update(AddOne, item.getSaleId(), item.getBrandedMedicineId(), item.getQuantity(), item.getUnitPrice());
    }

    public List<SaleItem> getAll() {
        return jdbc.query(getAll, new BeanPropertyRowMapper<>(SaleItem.class));
    }

}
