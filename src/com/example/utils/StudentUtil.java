package com.example.utils;

import com.example.daoImp.ManagerClassImpl;

public class StudentUtil {
    // 检测输入的学号是否正确
    public  static boolean checkStudentId(String studentId) {
        return true;
    }
    // 检测学院是否合法
    public static boolean checkCollege(String college) {
        return true;
    }

    // 检测专业是否合法
    public static boolean checkMajor(String major) {
        return true;
    }

    // 检测班级是否合法
    public static boolean checkClass(String classId) {
        if (new ManagerClassImpl().findClass(classId, "classId") != null) {
            return true;
        }
        return false;
    }

}
