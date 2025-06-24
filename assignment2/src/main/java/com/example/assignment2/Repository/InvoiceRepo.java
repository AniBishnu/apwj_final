package com.example.assignment2.Repository;

import com.example.assignment2.Entity.Invoice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class InvoiceRepo {
    private final JdbcTemplate jdbc;

    private final String GetAll = "SELECT * FROM invoice";
    private final String GetByUser = "SELECT i.* FROM invoice i JOIN orders o ON i.order_id = o.id WHERE o.user_id = ?";
    private final String AddOne = "INSERT INTO invoice (order_id, invoice_date, total_amount, discount_applied, final_amount) VALUES (?, ?, ?, ?, ?)";

    public InvoiceRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Invoice> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Invoice.class));
    }

    public List<Invoice> getByUserId(int userId) {
        return jdbc.query(GetByUser, new Object[]{userId}, new BeanPropertyRowMapper<>(Invoice.class));
    }

    public void generateInvoice(Invoice invoice) {
        jdbc.update(AddOne,
                invoice.orderId,
                invoice.invoiceDate,
                invoice.totalAmount,
                invoice.discountApplied,
                invoice.finalAmount
        );
    }
}
