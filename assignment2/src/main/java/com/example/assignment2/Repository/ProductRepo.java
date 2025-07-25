package com.example.assignment2.Repository;

import com.example.assignment2.Entity.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

@Repository
public class ProductRepo {
    public JdbcTemplate jdbc;
    public String GetAll = "SELECT * FROM product";
    public String GetById = "SELECT * FROM product WHERE id=?";
    public String AddOne = "INSERT INTO product (name, category, price, quantity, expiry_date, available) VALUES (?, ?, ?, ?, ?, ?)";
    public String UpdateOne = "UPDATE product SET name=?, category=?, price=?, quantity=?, expiry_date=?, available=? WHERE id=?";
    public String DeleteOne = "DELETE FROM product WHERE id=?";

    public ProductRepo(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    public List<Product> getAll() {
        return jdbc.query(GetAll, new BeanPropertyRowMapper<>(Product.class));
    }

    public Product getById(int id) {
        return jdbc.queryForObject(GetById, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public void addProduct(Product product) {
        jdbc.update(AddOne,
                product.name,
                product.category.toString(),
                product.price,
                product.quantity,
                Date.valueOf(product.expiryDate),
                product.available
        );
    }

    public void updateProduct(Product product) {
        jdbc.update(UpdateOne,
                product.name,
                product.category.toString(),
                product.price,
                product.quantity,
                Date.valueOf(product.expiryDate),
                product.available,
                product.id
        );
    }

    public void deleteProduct(int id) {
        jdbc.update(DeleteOne, id);
    }
}
