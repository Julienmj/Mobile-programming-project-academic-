package com.example.quiz_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    private RecyclerView recyclerViewStudents;
    private StudentAdapter studentAdapter;
    private Button btnAddNewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        initViews();
        setupRecyclerView();
        setupClickListeners();
    }

    private void initViews() {
        recyclerViewStudents = findViewById(R.id.recyclerViewStudents);
        btnAddNewStudent = findViewById(R.id.btnAddNewStudent);
    }

    private void setupRecyclerView() {
        List<Student> students = StudentDataSource.getStudents();
        studentAdapter = new StudentAdapter(students);
        
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStudents.setAdapter(studentAdapter);
    }

    private void setupClickListeners() {
        btnAddNewStudent.setOnClickListener(v -> {
            Intent intent = new Intent(StudentListActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the list when coming back to this activity
        List<Student> students = StudentDataSource.getStudents();
        studentAdapter.updateList(students);
        
        if (students.isEmpty()) {
            Toast.makeText(this, "No students registered yet", Toast.LENGTH_SHORT).show();
        }
    }
}
