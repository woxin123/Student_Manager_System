package com.example.service.impl;

import com.example.daoImp.ManagerStudentImpl;
import com.example.domain.Student;
import com.example.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public boolean addStudent(Student student) {
        return new ManagerStudentImpl().addStudent(student);
    }

    @Override
    public boolean deleteStudent(String studentId) {
        return new ManagerStudentImpl().deleteStudent(studentId);
    }

    @Override
    public boolean modify(Student student) {
        return new ManagerStudentImpl().modifyStudent(student);
    }

    @Override
    public Student find(String studentId) {
        return new ManagerStudentImpl().findStudent(studentId);
    }

    @Override
    public Student find(String studentId, String password) {
        return new ManagerStudentImpl().findStudent(studentId, password);
    }
}
