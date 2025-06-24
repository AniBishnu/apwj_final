package com.example.assignment2.Repository;

import com.example.assignment2.Entity.CartItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CartItemRepo {
    public final JdbcTemplate jdbc;

    public String GetAllByCartId = "SELECT * FROM cartitem WHERE cart_id=?";
    public String AddOne = "INSERT INTO cartitem (cart_id, product_id, quantity) VALUES (?, ?, ?)";
    public String UpdateQuantity = "UPDATE cartitem SET quantity=? WHERE id=?";
    public String DeleteOne = "DELETE FROM cartitem WHERE id=?";

    public CartItemRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<CartItem> getByCartId(int cartId) {
        return jdbc.query(GetAllByCartId, new Object[]{cartId}, new BeanPropertyRowMapper<>(CartItem.class));
    }

    public void addCartItem(CartItem item) {
        jdbc.update(AddOne, item.getCartID(), item.getProductID(), item.getQuantity());
    }

    public void updateQuantity(int id, int quantity) {
        jdbc.update(UpdateQuantity, quantity, id);
    }

    public void removeCartItem(int id) {
        jdbc.update(DeleteOne, id);
    }
}
