package com.example.quiz_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputEditText etStudentId, etFullName, etPhoneNumber, etEmail;
    private RadioGroup rgGender;
    private Button btnRegister, btnViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etStudentId = findViewById(R.id.etStudentId);
        etFullName = findViewById(R.id.etFullName);
        rgGender = findViewById(R.id.rgGender);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etEmail = findViewById(R.id.etEmail);
        btnRegister = findViewById(R.id.btnRegister);
        btnViewList = findViewById(R.id.btnViewList);

        btnRegister.setOnClickListener(v -> registerStudent());
        btnViewList.setOnClickListener(v -> {
            startActivity(new Intent(this, StudentListActivity.class));
        });
    }

    private void registerStudent() {
        String studentId = etStudentId.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (!isValid(studentId, 3)) {
            etStudentId.setError("Required (min 3 chars)");
            return;
        }
        if (!isValid(fullName, 2)) {
            etFullName.setError("Required (min 2 chars)");
            return;
        }
        if (!isValid(phoneNumber, 10) || !phoneNumber.matches("[0-9+]+")) {
            etPhoneNumber.setError("Valid phone required");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Valid email required");
            return;
        }

        int selectedId = rgGender.getCheckedRadioButtonId();
        String gender = selectedId == R.id.rbMale ? "MALE" : 
                       selectedId == R.id.rbFemale ? "FEMALE" : null;
        
        if (gender == null) {
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        StudentDataSource.addStudent(new Student(studentId, fullName, gender, phoneNumber, email));
        Toast.makeText(this, "Registered!", Toast.LENGTH_SHORT).show();
        clearForm();
    }

    private void clearForm() {
        etStudentId.setText("");
        etFullName.setText("");
        etPhoneNumber.setText("");
        etEmail.setText("");
        rgGender.clearCheck();
    }

    private boolean isValid(String input, int minLength) {
        return input != null && input.length() >= minLength;
    }
}
