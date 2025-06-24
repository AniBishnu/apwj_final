package com.example.assignment2.Controller;

import com.example.assignment2.Entity.User;
import com.example.assignment2.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }
}
