package com.example.service;

import com.example.domain.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);
    boolean deleteStudent(String studentId);
    boolean modify(Student student);
    Student find(String studentId);
    Student find(String studentId, String password);
    List<Student> allStudents();
}
