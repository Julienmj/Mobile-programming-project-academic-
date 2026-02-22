# Quiz 3 - Student Management System

A complete Android application for student registration and management with custom list display.

## Features Implemented

### Core Components
- **Student Model**: Created `Student.java` class with attributes (studentId, fullName, gender, phoneNumber, email)
- **Registration Form**: Material Design form with validation for all student fields
- **Student List**: Full-screen RecyclerView with custom layout matching whiteboard design
- **Data Management**: In-memory storage using `StudentDataSource.java`

### UI/UX Implementation
- **MainActivity**: Navigation hub with buttons for registration and list view
- **RegistrationActivity**: Complete form with input validation and error handling
- **StudentListActivity**: Full-screen display with custom item layout
- **Custom Layout**: Student items showing NAMES (16dp), PhoneNo (12dp), EMAIL (12dp), gender badge (F/M) in top-right corner

### Design Specifications
- Gender badges display single letters ('F'/'M') with WhatsApp-style green (male) and pink (female) backgrounds
- Full-screen list layout without padding
- Material Design components throughout
- Proper navigation between activities

## Technical Implementation
- Java-based Android application
- RecyclerView with custom adapter
- Material Design components
- Form validation and error handling
- Activity navigation and data persistence

## Project Structure
- **Minimal Design**: 4 Java files, 2 activities for simplicity
- **Clean Architecture**: Separated concerns with model, view, and data layers
- **Efficient Code**: Optimized for performance and maintainability

## Screenshots

### Registration Form
![Registration Form](screenshots/Screenshot%202026-02-10%20150853.png)

### Student List Display
![Student List](screenshots/Screenshot%202026-02-10%20150908.png)

## AI Assistance
This project was developed with AI assistance from AI.

## Repository Status
- **Last Updated**: February 2026
- **Version**: 1.0.0
- **Status**: Active Development
