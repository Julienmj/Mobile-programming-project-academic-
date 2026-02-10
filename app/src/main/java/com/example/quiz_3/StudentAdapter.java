package com.example.quiz_3;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        
        holder.tvFullName.setText(student.getFullName());
        holder.tvPhoneNumber.setText(student.getPhoneNumber());
        holder.tvEmail.setText(student.getEmail());
        
        // Display gender as 'F' or 'M'
        String genderInitial = student.getGender().substring(0, 1).toUpperCase();
        holder.tvGender.setText(genderInitial);
        
        // Set different background colors based on gender using color resources
        if ("MALE".equals(student.getGender())) {
            holder.tvGender.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.gender_male));
        } else if ("FEMALE".equals(student.getGender())) {
            holder.tvGender.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.gender_female));
        }
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public void updateList(List<Student> newStudentList) {
        this.studentList = newStudentList;
        notifyDataSetChanged();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName;
        TextView tvPhoneNumber;
        TextView tvEmail;
        TextView tvGender;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvGender = itemView.findViewById(R.id.tvGender);
        }
    }
}
