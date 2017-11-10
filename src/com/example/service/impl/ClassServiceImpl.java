package com.example.service.impl;

import com.example.daoImp.ManagerClassImpl;
import com.example.domain.MyClass;
import com.example.domain.Teacher;
import com.example.service.ClassService;

import java.util.List;

public class ClassServiceImpl implements ClassService {
    @Override
    public boolean addClass(MyClass myClass) {
        return new ManagerClassImpl().addClass(myClass);
    }

    @Override
    public boolean deleteClass(String classId) {
        return new ManagerClassImpl().deleteClass(classId);
    }

    @Override
    public boolean modifyClass(MyClass myClass) {
        return new ManagerClassImpl().modifyClass(myClass);
    }

    @Override
    public MyClass findClass(String role, String type) {
        return new ManagerClassImpl().findClass(role, type);
    }

    @Override
    public List<MyClass> allTeacher() {
        return new ManagerClassImpl().allClass();
    }

    @Override
    public List<MyClass> findSomeClass(String role, String type) {
        return new ManagerClassImpl().findSomeClass(role, type);
    }
}
