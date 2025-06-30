package com.example.Vitascript.Repository;

import com.example.Vitascript.Entity.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PaymentRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM payment";
    public String AddOne = "INSERT INTO payment (sale_id, method, amount, payment_date, transaction_id) VALUES (?, ?, ?, ?, ?)";

    public PaymentRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Payment> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Payment.class));
    }

    public void add(Payment payment) {
        jdbc.update(AddOne, payment.getSaleId(), payment.getMethod(), payment.getAmount(), payment.getPaymentDate(), payment.getTransactionId());
    }
}
