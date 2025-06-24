package com.example.assignment2.Repository;

import com.example.assignment2.Entity.Cart;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository
public class CartRepo {
    private final JdbcTemplate jdbc;

    public String CreateCart = "INSERT INTO cart (user_id) VALUES (?)";
    public String GetByUser = "SELECT * FROM cart WHERE user_id=?";

    public CartRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public Cart getCartByUserId(int userId) {
        List<Cart> carts = jdbc.query(GetByUser, new Object[]{userId}, new BeanPropertyRowMapper<>(Cart.class));
        return carts.isEmpty() ? null : carts.get(0);
    }

    public void createCart(int userId) {
        jdbc.update(CreateCart, userId);
    }
}
