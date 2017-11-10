package com.example.dao;

import com.example.domain.MyClass;

import java.util.List;

public interface ManagerClass {
    boolean addClass(MyClass myclass);      // 添加班级
    boolean deleteClass(String classId);    // 删除班级
    MyClass findClass(String role, String type);      // 查找班级
    boolean modifyClass(MyClass myclass);   // 修改班级信息
    boolean addClassStudent(String classId); // 当添加学生是执行这个方法
    boolean minusClassStudent(String classId);  // 当删除学生时执行这个方法
    List<MyClass> allClass();
    List<MyClass> findSomeClass(String role, String type);
}
