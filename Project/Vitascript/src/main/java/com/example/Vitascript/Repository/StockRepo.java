package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.Stock;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StockRepo {

    private final JdbcTemplate jdbc;

    private static final String GET_LOW_STOCK = "SELECT * FROM stock WHERE quantity < 10";
    private static final String UPDATE_QUANTITY = "UPDATE stock SET quantity=? WHERE pharmacy_id=? AND branded_medicine_id=?";
    private static final String GET_BY_PHARMACY = "SELECT * FROM stock WHERE pharmacy_id=?";
    private static final String GET_SPECIFIC_STOCK = "SELECT * FROM stock WHERE pharmacy_id=? AND branded_medicine_id=?";
    private static final String INSERT_STOCK = "INSERT INTO stock (pharmacy_id, branded_medicine_id, quantity) VALUES (?, ?, ?)";
    private static final String DECREASE_QUANTITY = "UPDATE stock SET quantity = quantity - ? WHERE pharmacy_id=? AND branded_medicine_id=?";

    public StockRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Stock> getLowStock() {
        return jdbc.query(GET_LOW_STOCK, new BeanPropertyRowMapper<>(Stock.class));
    }

    public List<Stock> getByPharmacy(int pharmacyId) {
        return jdbc.query(GET_BY_PHARMACY, new Object[]{pharmacyId}, new BeanPropertyRowMapper<>(Stock.class));
    }

    public Stock getStock(int pharmacyId, int brandedMedicineId) {
        List<Stock> results = jdbc.query(GET_SPECIFIC_STOCK, new Object[]{pharmacyId, brandedMedicineId}, new BeanPropertyRowMapper<>(Stock.class));
        return results.isEmpty() ? null : results.get(0);
    }

    public void update(Stock stock) {
        jdbc.update(UPDATE_QUANTITY, stock.getQuantity(), stock.getPharmacyId(), stock.getBrandedMedicineId());
    }

    public void add(Stock stock) {
        jdbc.update(INSERT_STOCK, stock.getPharmacyId(), stock.getBrandedMedicineId(), stock.getQuantity());
    }

    public void decreaseStock(int pharmacyId, int brandedMedicineId, int quantity) {
        jdbc.update(DECREASE_QUANTITY, quantity, pharmacyId, brandedMedicineId);
    }
}
