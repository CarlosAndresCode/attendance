package com.ancode.attendance.dtos;

import com.ancode.attendance.emun.Role;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Role role;
}
