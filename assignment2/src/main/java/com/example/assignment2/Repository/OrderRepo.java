package com.example.assignment2.Repository;

import com.example.assignment2.Entity.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class OrderRepo {
    public JdbcTemplate jdbc;

    public String GetAll = "SELECT * FROM order";
    public String GetByUser = "SELECT * FROM orders WHERE user_id=?";
    public String AddOne = "INSERT INTO orders (user_id, order_date, total_amount) VALUES (?, ?, ?)";

    public OrderRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Order> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Order.class));
    }

    public List<Order> getByUserId(int userId) {
        return jdbc.query(GetByUser, new Object[]{userId}, new BeanPropertyRowMapper<>(Order.class));
    }

    public void createOrder(Order order) {
        jdbc.update(AddOne, order.userId, order.orderDate, order.totalAmount);
    }
}
