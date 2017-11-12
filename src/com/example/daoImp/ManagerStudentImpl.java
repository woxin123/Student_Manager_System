package com.example.daoImp;

import com.example.dao.ManagerStudent;
import com.example.domain.Student;
import com.example.utils.MySQLCoonnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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
            Student student = findStudent(studentId);
            stmt.execute("DELETE FROM student where student_id='" + studentId + "';");
            new ManagerClassImpl().minusClassStudent(student.getStudentClass());
            isOK = true;
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
                    " student_gender=?, student_age=?, student_college=?, class_id=?, " +
                    " student_major=?, admissionDate=?,  student_phone=?,  student_address=?, " +
                    " student_dormitor=? where student_id='" + student.getStudentId() + "';");
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

    @Override
    public List<Student> allStudents() {
        List<Student> allStudents = new LinkedList<>();
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from student;");
            while (rs.next()) {
                Student student = new Student();
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
                allStudents.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    @Override
    public List<Student> findSomeStudent(String role, String type) {
        List<Student> someStudent = new LinkedList<>();
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            if (type.equals("ID")) {
                rs = stmt.executeQuery("SELECT * FROM student WHERE student_id LIKE '"+ "%" + role +  "%" +"';");
            } else if (type.equals("姓名")){
                rs = stmt.executeQuery("SELECT * FROM student WHERE student_name LIKE '"+ "%" + role +  "%" +"';");
            } else if (type.equals("性别")) {
                rs = stmt.executeQuery("SELECT * FROM student WHERE student_gender LIKE '"+ "%" + role +  "%" +"';");
            } else if (type.equals("学院")) {
                rs = stmt.executeQuery("SELECT * FROM student WHERE student_college LIKE '"+ "%" + role +  "%" +"';");
            } else if (type.equals("专业")) {
                rs = stmt.executeQuery("SELECT * FROM student WHERE student_major LIKE '"+ "%" + role +  "%" +"';");
            } else if (type.equals("班级")) {
                rs = stmt.executeQuery("SELECT * FROM student WHERE class_id LIKE '"+ "%" + role +  "%" +"';");
            } else if (type.equals("入学年份")) {
                rs = stmt.executeQuery("SELECT * FROM student WHERE admissionDate LIKE '"+ "%" + role +  "%" +"';");
            } else if (type.equals("宿舍")) {
                rs = stmt.executeQuery("SELECT * FROM student WHERE student_dormitor LIKE '"+ "%" + role +  "%" +"';");
            }
            while (rs.next()) {
                Student student = new Student();
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
                someStudent.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return someStudent;
    }

    private String setDefaultPassword() {
        return "111111";
    }
}
