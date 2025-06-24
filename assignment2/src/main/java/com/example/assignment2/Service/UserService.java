package com.example.assignment2.Service;

import com.example.assignment2.Entity.User;
import com.example.assignment2.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.getAll();
    }

    public User getByUsername(String username) {
        return userRepo.getByUsername(username);
    }

    public void registerUser(User user) {
        userRepo.addUser(user);
    }
}
