package com.example.utils;

import com.example.daoImp.ManagerClassImpl;
import com.example.domain.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class StudentUtil {
    // 检测输入的学号是否正确
    public static boolean checkStudentId(String studentId) {
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

    public Student toBean(HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        Student student = new Student();
        String studentId = request.getParameter("studentId");
        if (studentId.equals("")) {
            errors.put("studentId", "Id不能为空");
        } else if (!StudentUtil.checkStudentId(studentId)) {
            errors.put("studentId", "Id不符合规则");
        }
        student.setStudentId(studentId);
        String studentName = request.getParameter("studentName");
        student.setName(studentName);
        if (studentName.length() < 1) {
            errors.put("studentName", "该姓名太短");
        } else if (studentName.length() > 4) {
            errors.put("studetName", "该名称太长");
        }
        String studentGender = request.getParameter("studentGender");
        student.setGender(studentGender.charAt(0));
        if (request.getParameter("studentAge").equals("")) {
            errors.put("studentAge", "年龄不为为空");
        } else {
            int studentAge = Integer.parseInt(request.getParameter("studentAge"));
            student.setAge(studentAge);
            if (studentAge < 0 || studentAge > 100) {
                errors.put("studentAge", "年龄不符合要求");
            }
        }
        String studentCollege = request.getParameter("studentCollege");
        student.setCollege(studentCollege);
        if (studentCollege.equals("")) {
            errors.put("studentCollege", "学院不能为空");
        } else if (!StudentUtil.checkCollege(studentCollege)) {
            errors.put("studentCollege", "学院不合法");
        }
        String studentMajor = request.getParameter("studentMajor");
        student.setMajor(studentMajor);
        if (studentMajor.equals("")) {
            errors.put("studentMajor", "专业不能为空");
        } else if (!StudentUtil.checkMajor(studentMajor)) {
            errors.put("studentMajor", "专业不合法");
        }
        String classId = request.getParameter("studentClass");
        student.setStudentClass(classId);
        if (classId.equals("")) {
            errors.put("studentClass", "班级不能为空");
        } else if (!StudentUtil.checkClass(classId)) {
            errors.put("studentClass", "班级不存在");
        }
        String admissionDate = request.getParameter("studentAdmissionDate");
        if (admissionDate.equals("")) {
            errors.put("studentAdmissionDate", "入学时间不能为空");
        }
        student.setAdmissionDate(admissionDate);
        String phone = request.getParameter("studentPhone");
        if (phone.equals("")) {
            student.setPhone("");
        }
        String address = request.getParameter("studentAddress");
        if (address.equals(""))
            student.setAddress("");
        else
            student.setAddress(address);
        String dormitory = request.getParameter("studentDormitory");
        if (dormitory.equals(""))
            student.setDormitory("");
        else
            student.setDormitory(dormitory);
        if (errors.size() == 0)
            return student;
        else {
            request.setAttribute("errors", errors);
            return null;
        }
    }
}
