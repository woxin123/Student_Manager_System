package com.example.dao;

import com.example.domain.Teacher;

import java.sql.ResultSet;

public interface ManagerTeacher {
    boolean addTeacher(Teacher teacher); // 添加老师
    boolean deleteTeacher(String teacherId); // 删除老师
    boolean modifyTeacher(Teacher teacher); // 修改老师信息
    Teacher find(String teacherName);       // 查找老师
    Teacher find(String teacherName, String password);
    ResultSet findAllTeacher();
    ResultSet findTeacher(String rule, String type);
}
