package com.ancode.attendance.emun;

public enum Role {
    ADMIN,
    USER,
    GUEST;

    public static Role fromString(String role) {
        try {
            return Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // or throw an exception if preferred
        }
    }
}
