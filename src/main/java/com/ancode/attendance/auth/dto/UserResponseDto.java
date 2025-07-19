package com.ancode.attendance.auth.dto;

import com.ancode.attendance.auth.emun.Role;
import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;
}
