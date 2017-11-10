package com.example.domain;

import java.io.Serializable;

public class MyClass implements Serializable{
    private static final long serialVersionUID = -1057573702347155275L;
    // 班级编号
    private String classId;
    // 班级名称
    private String className;
    // 班级所在的学院
    private String classCollege;
    // 班级所在的专业
    private String classMajor;
    // 班级创建的时间
    private String time;
    // 班级总人数
    private int total;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCollege() {
        return classCollege;
    }

    public void setClassCollege(String classCollege) {
        this.classCollege = classCollege;
    }

    public String getClassMajor() {
        return classMajor;
    }

    public void setClassMajor(String classMajor) {
        this.classMajor = classMajor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
