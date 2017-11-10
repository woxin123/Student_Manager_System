package com.example.service;

import com.example.domain.Teacher;

public interface TeacherService {
    boolean addTeacher(Teacher teacher);
    boolean deleteTeacher(String teacherId);
    boolean modifyTeacher(Teacher teacher);
    Teacher findTeacher(String teacherId);
    Teacher findTeacher(String teacherId, String password);
}
