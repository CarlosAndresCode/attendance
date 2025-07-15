package com.ancode.attendance.services;

import com.ancode.attendance.emun.Role;
import com.ancode.attendance.entities.User;
import com.ancode.attendance.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void createAdminUser(){
        User user = userRepository.findByRole(Role.ADMIN);

        if (user == null) {

            user = new User();
            user.setName("Admin");
            user.setEmail("email@email.com");
            user.setPassword("password");
            user.setRole(Role.ADMIN);

            userRepository.save(user);

            System.out.println("Admin user created successfully.");
        } else {
            System.out.println("Admin user already exists.");
        }
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
