package com.example.quiz_3;

import java.util.ArrayList;
import java.util.List;

public class StudentDataSource {
    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public static void clearStudents() {
        students.clear();
    }

    public static int getStudentCount() {
        return students.size();
    }
}
