package com.example.quiz_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_simple, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Student student = students.get(position);
            
            holder.tvFullName.setText(student.getFullName());
            holder.tvPhoneNumber.setText(student.getPhoneNumber());
            holder.tvEmail.setText(student.getEmail());
            
            // Display gender as 'F' or 'M'
            String genderInitial = student.getGender().substring(0, 1).toUpperCase();
            holder.tvGender.setText(genderInitial);
            
            // Set different background colors based on gender
            if ("MALE".equals(student.getGender())) {
                holder.tvGender.setBackgroundColor(android.graphics.Color.parseColor("#25D366")); // WhatsApp green
            } else if ("FEMALE".equals(student.getGender())) {
                holder.tvGender.setBackgroundColor(android.graphics.Color.parseColor("#E91E63")); // Pink for female
            }
        }

        @Override
        public int getItemCount() {
            return students.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvFullName, tvPhoneNumber, tvEmail, tvGender;

            ViewHolder(View view) {
                super(view);
                tvFullName = view.findViewById(R.id.tvFullName);
                tvPhoneNumber = view.findViewById(R.id.tvPhoneNumber);
                tvEmail = view.findViewById(R.id.tvEmail);
                tvGender = view.findViewById(R.id.tvGender);
            }
        }
    }
}
