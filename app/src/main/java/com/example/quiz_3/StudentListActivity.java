package com.example.quiz_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnAddNew;
    private List<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyclerView = findViewById(R.id.recyclerViewStudents);
        btnAddNew = findViewById(R.id.btnAddNewStudent);

        setupRecyclerView();
        btnAddNew.setOnClickListener(v -> finish()); // Go back to registration
    }

    private void setupRecyclerView() {
        students = StudentDataSource.getStudents();
        SimpleStudentAdapter adapter = new SimpleStudentAdapter(students);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        students = StudentDataSource.getStudents();
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    // Simple adapter moved here as inner class
    private static class SimpleStudentAdapter extends RecyclerView.Adapter<SimpleStudentAdapter.ViewHolder> {
        private List<Student> students;

        public SimpleStudentAdapter(List<Student> students) {
            this.students = students;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView view = new TextView(parent.getContext());
            view.setPadding(32, 24, 32, 24);
            view.setTextSize(16);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Student student = students.get(position);
            String gender = student.getGender().substring(0, 1);
            holder.textView.setText(student.getFullName() + " | " + student.getPhoneNumber() + 
                                 " | " + student.getEmail() + " | " + gender);
        }

        @Override
        public int getItemCount() {
            return students.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            ViewHolder(TextView view) {
                super(view);
                textView = view;
            }
        }
    }
}
