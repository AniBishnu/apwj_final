package com.example.Vitascript.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    public int id;
    public String name;
    public String password;
    public String phone;
    public String email;
    public String address;
    public LocalDate dob;
    public Role role;
    public LocalDateTime createdTime;

    public User(int id, String name, String password, String phone, String email, String address, LocalDate dob, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.role = role;
        this.createdTime=LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Role getRole() {
        return role;
    }

    public void setRoleId(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}

