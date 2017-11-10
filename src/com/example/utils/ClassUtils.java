package com.example.utils;

import com.example.domain.MyClass;
import com.example.domain.Teacher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ClassUtils {
    public MyClass toBean(HttpServletRequest request) {
        MyClass myClass = new MyClass();
        Map<String, String> errors = new HashMap<>();
        myClass.setClassId(request.getParameter("classId"));
        boolean isOK = true;
        if (myClass.getClassId().equals("") || myClass.getClassId() == null) {
            errors.put("classId", "classId不能为空");
            isOK = false;
        }
        myClass.setClassName(request.getParameter("className"));
        if (myClass.getClassName().equals("")) {
            errors.put("className", "className不能为空");
            isOK = false;
        }
        myClass.setClassCollege(request.getParameter("classCollege"));
        if (myClass.getClassCollege().equals("")) {
            errors.put("classCollege", "所在学院不能为空");
            isOK = false;
        }
        myClass.setClassMajor(request.getParameter("classMajor"));
        if (myClass.getClassMajor().equals("")) {
            errors.put("classMajor", "所在专业不能为空");
            isOK = false;
        }
        myClass.setTime(request.getParameter("classTime"));
        if (myClass.getTime().equals("")) {
            errors.put("classTime", "创建时间不能为空");
            isOK = false;
        }
        request.setAttribute("errors", errors);
        if (isOK == false)
            return null;
        return myClass;
    }
}
