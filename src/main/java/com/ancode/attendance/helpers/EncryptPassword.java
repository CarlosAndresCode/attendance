package com.ancode.attendance.helpers;

import org.springframework.stereotype.Component;

@Component
public class EncryptPassword {

    public static String encrypt(String password) {
        // Simple encryption logic (for demonstration purposes only)
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            encrypted.append((char) (c + 3)); // Shift each character by 3
        }
        return encrypted.toString();
    }

    public static String decrypt(String encryptedPassword) {
        // Simple decryption logic (for demonstration purposes only)
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedPassword.toCharArray()) {
            decrypted.append((char) (c - 3)); // Shift each character back by 3
        }
        return decrypted.toString();
    }
}
