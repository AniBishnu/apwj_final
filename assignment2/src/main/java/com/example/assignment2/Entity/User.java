package com.example.assignment2.Entity;

public class User {
    public int id;
    public String username;
    public String password;
    public String email;
    public int role_id;
    public User() {
    }

    public User(int id, String username, String password, String email, int role_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role_id;
    }

    public void setRole(int role_id) {
        this.role_id = role_id;
    }
}
