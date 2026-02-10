package com.example.quiz_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputEditText etStudentId;
    private TextInputEditText etFullName;
    private RadioGroup rgGender;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private TextInputEditText etPhoneNumber;
    private TextInputEditText etEmail;
    private Button btnRegister;
    private Button btnViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        etStudentId = findViewById(R.id.etStudentId);
        etFullName = findViewById(R.id.etFullName);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etEmail = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btnRegister);
        btnViewList = findViewById(R.id.btnViewList);
    }

    private void setupClickListeners() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerStudent();
            }
        });

        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, StudentListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerStudent() {
        String studentId = etStudentId.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (!Utils.isValidStudentId(studentId)) {
            etStudentId.setError("Student ID must be at least 3 characters");
            return;
        }

        if (!Utils.isValidName(fullName)) {
            etFullName.setError("Full Name must be at least 2 characters");
            return;
        }

        if (!Utils.isValidPhone(phoneNumber)) {
            etPhoneNumber.setError("Please enter a valid phone number (at least 10 digits)");
            return;
        }

        if (!Utils.isValidEmail(email)) {
            etEmail.setError("Please enter a valid email address");
            return;
        }

        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        String gender;
        if (selectedGenderId == R.id.rbMale) {
            gender = "MALE";
        } else if (selectedGenderId == R.id.rbFemale) {
            gender = "FEMALE";
        } else {
            Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = new Student(studentId, fullName, gender, phoneNumber, email);
        
        StudentDataSource.addStudent(student);
        
        Toast.makeText(this, "Student registered successfully!", Toast.LENGTH_SHORT).show();
        clearForm();
    }

    private void clearForm() {
        etStudentId.setText("");
        etFullName.setText("");
        etPhoneNumber.setText("");
        etEmail.setText("");
        rgGender.clearCheck();
    }
}
