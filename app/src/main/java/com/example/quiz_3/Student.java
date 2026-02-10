package com.example.quiz_3;

public class Student {
    private String studentId, fullName, gender, phoneNumber, email;

    public Student() {}

    public Student(String studentId, String fullName, String gender, String phoneNumber, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getFullName() { return fullName; }
    public String getGender() { return gender; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    // Setters
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
}
