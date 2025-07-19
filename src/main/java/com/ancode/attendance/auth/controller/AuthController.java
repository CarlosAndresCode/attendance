package com.ancode.attendance.auth.controller;

import com.ancode.attendance.auth.dto.LoginRequestDto;
import com.ancode.attendance.auth.dto.UserResponseDto;
import com.ancode.attendance.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen
public class AuthController {

    @Autowired
    private AuthService authService;

     @PostMapping("/login")
     public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
         UserResponseDto userResponseDto = authService.login(loginRequest);
         return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
     }
}
