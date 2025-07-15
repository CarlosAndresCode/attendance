package com.ancode.attendance.Controllers;

import com.ancode.attendance.dtos.LoginRequestDto;
import com.ancode.attendance.dtos.UserDto;
import com.ancode.attendance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen
public class AuthController {

    @Autowired
    private UserService userService;

     @PostMapping("/login")
     public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequest) {
         UserDto userDto = userService.login(loginRequest);
         return new ResponseEntity<>(userDto, HttpStatus.OK);
     }
}
