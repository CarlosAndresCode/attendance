package com.ancode.attendance.auth.entity;

import com.ancode.attendance.auth.dto.UserResponseDto;
import com.ancode.attendance.auth.emun.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;

    public UserResponseDto getToDto() {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(this.id);
        userResponseDto.setName(this.name);
        userResponseDto.setEmail(this.email);
        userResponseDto.setPassword(this.password);
        userResponseDto.setRole(this.role);
        return userResponseDto;
    }

}
