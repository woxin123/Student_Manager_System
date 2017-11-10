package com.example.domain;

import java.io.Serializable;

public class Teacher implements Serializable{
    private static final long serialVersionUID = 4378082808122268598L;
    // 工号
    private String teacherId;
    // 姓名
    private String name;
    // 性别
    private char gender;
    // 年龄
    private int age;

    // 所在学院
    private String college;
    // 个人简介
    private String introduce;

    // 联系电话
    private String phone;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
