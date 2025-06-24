package com.example.assignment2.Service;

import com.example.assignment2.Entity.Role;
import com.example.assignment2.Repository.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    public RoleRepo roleRepo;
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> getAllRoles() {
        return roleRepo.getAll();
    }

    public Role getById(int id) {
        return roleRepo.getById(id);
    }
}
