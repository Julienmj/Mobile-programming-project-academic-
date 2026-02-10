package com.example.quiz_3;

/**
 * Constants used throughout the application
 */
public class Constants {
    
    // Validation constraints
    public static final int MIN_STUDENT_ID_LENGTH = 3;
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MIN_PHONE_LENGTH = 10;
    
    // Gender constants
    public static final String GENDER_MALE = "MALE";
    public static final String GENDER_FEMALE = "FEMALE";
    public static final String GENDER_INITIAL_MALE = "M";
    public static final String GENDER_INITIAL_FEMALE = "F";
    
    // UI constants
    public static final int NAME_TEXT_SIZE = 16;
    public static final int DETAIL_TEXT_SIZE = 12;
    public static final int GENDER_BADGE_SIZE = 14;
    
    // Error messages
    public static final String ERROR_STUDENT_ID = "Student ID must be at least 3 characters";
    public static final String ERROR_NAME = "Name must be at least 2 characters";
    public static final String ERROR_PHONE = "Please enter a valid phone number (at least 10 digits)";
    public static final String ERROR_EMAIL = "Please enter a valid email address";
    public static final String ERROR_GENDER = "Please select gender";
    
    // Success messages
    public static final String SUCCESS_REGISTRATION = "Student registered successfully!";
    public static final String SUCCESS_UPDATE = "Student updated successfully!";
    public static final String SUCCESS_DELETE = "Student deleted successfully!";
}
