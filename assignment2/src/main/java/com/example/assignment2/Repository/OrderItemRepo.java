package com.example.assignment2.Repository;

import com.example.assignment2.Entity.OrderItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrderItemRepo {
    public JdbcTemplate jdbc;

    public String GetByOrder = "SELECT * FROM orderitem WHERE order_id=?";
    public String AddOne = "INSERT INTO orderitem (order_id, product_id, quantity, price, final_price) VALUES (?, ?, ?, ?, ?)";

    public OrderItemRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<OrderItem> getItemsByOrderId(int orderId) {
        return jdbc.query(GetByOrder, new Object[]{orderId}, new BeanPropertyRowMapper<>(OrderItem.class));
    }

    public void addItem(OrderItem item) {
        jdbc.update(AddOne, item.orderId, item.productId, item.quantity, item.price);
    }

    public List<OrderItem> getAll() {
        return jdbc.query("SELECT * FROM order_items", new BeanPropertyRowMapper<>(OrderItem.class));
    }

}
