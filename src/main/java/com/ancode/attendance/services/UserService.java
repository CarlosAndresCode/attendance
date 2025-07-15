package com.ancode.attendance.services;

import com.ancode.attendance.dtos.LoginRequestDto;
import com.ancode.attendance.dtos.UserDto;
import com.ancode.attendance.emun.Role;
import com.ancode.attendance.entities.User;
import com.ancode.attendance.helpers.EncryptPassword;
import com.ancode.attendance.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

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
            user.setPassword(EncryptPassword.encrypt("password")); // Use the encryption helper
            user.setRole(Role.ADMIN);

            userRepository.save(user);

            System.out.println("Admin user created successfully.");
        } else {
            System.out.println("Admin user already exists.");
        }
    }

    public UserDto login(LoginRequestDto loginRequest) {
        if (loginRequest.getEmail().isEmpty() || loginRequest.getPassword().isEmpty()) {
            throw new RuntimeException("Email and password must not be null");
        }

        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent() && EncryptPassword.checkPassword(loginRequest.getPassword(), user.get().getPassword())) {
            return user.get().getToDto();
        }
        throw new RuntimeException("User not found with email: " + loginRequest.getEmail());
    }
}
