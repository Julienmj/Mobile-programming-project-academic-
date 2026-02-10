package com.example.quiz_3;

import android.util.Patterns;
import java.util.regex.Pattern;

/**
 * Utility class for validation and common operations
 */
public class Utils {
    
    /**
     * Validates email format
     * @param email Email string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    
    /**
     * Validates phone number format (basic validation)
     * @param phone Phone number to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.length() >= 10 && phone.matches("[0-9+]+");
    }
    
    /**
     * Validates student ID format
     * @param studentId Student ID to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidStudentId(String studentId) {
        return studentId != null && !studentId.trim().isEmpty() && studentId.length() >= 3;
    }
    
    /**
     * Validates name format
     * @param name Name to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }
}
