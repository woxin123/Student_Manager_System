package com.example.service.impl;

import com.example.daoImp.ManagerTeacherImpl;
import com.example.domain.Teacher;
import com.example.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public boolean addTeacher(Teacher teacher) {
        return new ManagerTeacherImpl().addTeacher(teacher);
    }

    @Override
    public boolean deleteTeacher(String teacherId) {
        return new ManagerTeacherImpl().deleteTeacher(teacherId);
    }

    @Override
    public boolean modifyTeacher(Teacher teacher) {
        return new ManagerTeacherImpl().modifyTeacher(teacher);
    }

    @Override
    public Teacher findTeacher(String teacherId) {
        return new ManagerTeacherImpl().find(teacherId);
    }

    @Override
    public Teacher findTeacher(String teacherId, String password) {
        return new ManagerTeacherImpl().find(teacherId, password);
    }
}
