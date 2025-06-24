package com.example.assignment2.Repository;

import com.example.assignment2.Entity.Wishlist;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class WishlistRepo {
    public JdbcTemplate jdbc;

    public String GetAllByUser = "SELECT * FROM wishlist WHERE userId=?";
    public String AddOne = "INSERT INTO wishlist (userId, productId) VALUES (?, ?)";

    public WishlistRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Wishlist> getWishlistByUserId(int userId) {
        return jdbc.query(GetAllByUser, new Object[]{userId},
                new BeanPropertyRowMapper<>(Wishlist.class));
    }

    public void addProductToWishlist(int userId, int productId) {
        jdbc.update(AddOne, userId, productId);
    }

    public void removeProductFromWishlist(int userId, int productId) {
        String sql = "DELETE FROM wishlist WHERE userId = ? AND productId = ?";
        jdbc.update(sql, userId, productId);
    }
}
