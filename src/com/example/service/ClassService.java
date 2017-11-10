package com.example.service;

import com.example.domain.MyClass;
import com.example.domain.Teacher;

import java.util.List;

public interface ClassService {
    boolean addClass(MyClass myClass);
    boolean deleteClass(String classId);
    boolean modifyClass(MyClass myClass);
    MyClass findClass(String role, String type);
    List<MyClass> allTeacher();
}
