package com.ancode.attendance.auth.service;

import com.ancode.attendance.auth.dto.LoginRequestDto;
import com.ancode.attendance.auth.dto.UserResponseDto;
import com.ancode.attendance.auth.emun.Role;
import com.ancode.attendance.auth.entity.User;
import com.ancode.attendance.auth.helpers.EncryptPassword;
import com.ancode.attendance.auth.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

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

    public UserResponseDto login(LoginRequestDto loginRequest) {
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
