package com.example.dao;

import com.example.domain.Student;

import java.util.List;

public interface ManagerStudent {
    Student findStudent(String studentId);
    Student findStudent(String studentId, String StudentName);
    boolean addStudent(Student student);
    boolean deleteStudent(String studentId);
    boolean modifyStudent(Student student);
    List<Student> allStudents();
    List<Student> findSomeStudent(String role, String type);
}
