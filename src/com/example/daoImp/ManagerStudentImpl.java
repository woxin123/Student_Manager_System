package com.example.daoImp;

import com.example.dao.ManagerStudent;
import com.example.domain.Student;
import com.example.utils.MySQLCoonnection;

import java.sql.*;

public class ManagerStudentImpl implements ManagerStudent {
    @Override
    public Student findStudent(String studentId) {
        Student student = null;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where student_id='" + studentId + "';");
            if (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setGender(rs.getString(3).charAt(0));
                student.setAge(rs.getInt(4));
                student.setCollege(rs.getString(5));
                student.setStudentClass(rs.getString(6));
                student.setMajor(rs.getString(7));
                student.setAdmissionDate(rs.getString(8));
                student.setPhone(rs.getString(9));
                student.setAddress(rs.getString(10));
                student.setDormitory(rs.getString(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return student;
    }

    @Override
    public Student findStudent(String studentId, String password) {
        Student student = null;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student where student_id='" +
                    studentId + "' and password='" + password + "';");
            if (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setGender(rs.getString(3).charAt(0));
                student.setAge(rs.getInt(4));
                student.setCollege(rs.getString(5));
                student.setStudentClass(rs.getString(6));
                student.setMajor(rs.getString(7));
                student.setAdmissionDate(rs.getString(8));
                student.setPhone(rs.getString(9));
                student.setAddress(rs.getString(10));
                student.setDormitory(rs.getString(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("insert into student " +
                    "VALUE (?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?,?)");
            pstmt.setString(1, student.getStudentId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, String.valueOf(student.getGender()));
            pstmt.setInt(4, student.getAge());
            pstmt.setString(5, student.getCollege());
            pstmt.setString(6, student.getStudentClass());
            pstmt.setString(7, student.getMajor());
            pstmt.setString(8, student.getAdmissionDate());
            pstmt.setString(9, student.getPhone());
            pstmt.setString(10, student.getAddress());
            pstmt.setString(11, student.getDormitory());
            pstmt.setString(12, new ManagerStudentImpl().setDefaultPassword());
            new ManagerClassImpl().addClassStudent(student.getStudentClass());
            pstmt.execute();
            isOK = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return isOK;
    }

    @Override
    public boolean deleteStudent(String studentId) {
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            isOK = stmt.execute("DELETE FROM student where student_id='" + studentId + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return isOK;
    }

    @Override
    public boolean modifyStudent(Student student) {
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE student set student_name=?, " +
                    "set student_gender=?, set student_age=?, set student_college=?, set class_id=?" +
                    " set student_major=?, set admissionDate=?, set student_phone=?, set student_address=? " +
                    "set student_dormitor=?;");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, String.valueOf(student.getGender()));
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getCollege());
            pstmt.setString(5, student.getStudentClass());
            pstmt.setString(6, student.getMajor());
            pstmt.setString(7, student.getAdmissionDate());
            pstmt.setString(8, student.getPhone());
            pstmt.setString(9, student.getAddress());
            pstmt.setString(10, student.getDormitory());
            pstmt.execute();
            isOK = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOK;
    }

    private String setDefaultPassword() {
        return "111111";
    }
}
