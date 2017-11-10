package com.example.daoImp;

import com.example.dao.ManagerTeacher;
import com.example.domain.Teacher;
import com.example.utils.MySQLCoonnection;

import java.sql.*;

public class ManagerTeacherImpl implements ManagerTeacher {

    @Override
    public boolean addTeacher(Teacher teacher) {
        MySQLCoonnection mysql = new MySQLCoonnection();
        boolean isOK = false;
        Connection conn = mysql.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt =conn.prepareStatement("insert into teacher VALUE (?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, teacher.getTeacherId());
            pstmt.setString(2, teacher.getName());
            pstmt.setString(3, String.valueOf(teacher.getGender()));
            pstmt.setInt(4, teacher.getAge());
            pstmt.setString(5, teacher.getCollege());
            pstmt.setString(6, teacher.getPhone());
            pstmt.setString(7, teacher.getIntroduce());
            pstmt.setString(8, ManagerTeacherImpl.setDefaultPassword());
            pstmt.execute();
            isOK = true;
        } catch (SQLException e) {
            isOK = false;
            System.out.println("执行添加老师语句错误");
            e.printStackTrace();
        }
        mysql.Close();
        return isOK;
    }

    @Override
    public boolean deleteTeacher(String teacherId) {
        MySQLCoonnection mysql = new MySQLCoonnection();
        boolean isOK = false;
        if (find(teacherId) != null) {
            Connection conn = mysql.getConnection();
            try {
                Statement stmt = conn.createStatement();
                stmt.execute("DELETE from teacher where teacher_id='" + teacherId + "';");
                isOK = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            isOK = false;
        }
        mysql.Close();
        return isOK;
    }

    @Override
    public boolean modifyTeacher(Teacher teacher) {
        MySQLCoonnection mysql = new MySQLCoonnection();
        boolean isOK = false;
        if (find(teacher.getTeacherId()) != null) {
            Connection conn = mysql.getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement("update teacher " +
                        "set teacher_name=?, teacher_gender=?, teacher_college=?, " +
                        "teacher_phone=?, teacher_introduce=?, teacher_age=? " +
                        "where teacher_id= '" + teacher.getTeacherId() + "';");
                pstmt.setString(1, teacher.getName());
                pstmt.setString(2, String.valueOf(teacher.getGender()));
                pstmt.setString(3, teacher.getCollege());
                pstmt.setString(4, teacher.getPhone());
                pstmt.setString(5, teacher.getIntroduce());
                pstmt.setInt(6, teacher.getAge());
                pstmt.execute();
                isOK = true;
            } catch (SQLException e) {
                isOK = false;
                e.printStackTrace();
            }
        } else {
            isOK = false;
        }
//        System.out.println(isOK);
        return isOK;
    }

    @Override
    public Teacher find(String teacherName) {
        MySQLCoonnection mysql = new MySQLCoonnection();
        Teacher teacher = null;
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from " +
                    "teacher where teacher_id = '" + teacherName + "';");
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setTeacherId(rs.getString(1));
                teacher.setName(rs.getString(2));
                teacher.setGender(rs.getString(3).charAt(0));
                teacher.setAge(rs.getInt(4));
                teacher.setCollege(rs.getString(5));
                teacher.setPhone(rs.getString(6));
                teacher.setIntroduce(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return teacher;
    }

    @Override
    public Teacher find(String teacherId, String password) {
        MySQLCoonnection mysql = new MySQLCoonnection();
        Teacher teacher = null;
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from " +
                    "teacher where teacher_id = '" + teacherId + "' and " +
                    "teacher_password='" + password + "';");
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setTeacherId(rs.getString(1));
                teacher.setName(rs.getString(2));
                teacher.setGender(rs.getString(3).charAt(0));
                teacher.setAge(rs.getInt(4));
                teacher.setCollege(rs.getString(5));
                teacher.setPhone(rs.getString(6));
                teacher.setIntroduce(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return teacher;
    }

    @Override
    public ResultSet findAllTeacher() {
        ResultSet rs = null;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from teacher");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 这块不能关闭
        return rs;
    }

    @Override
    public ResultSet findTeacher(String rule, String type) {
        ResultSet rs = null;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        if (type.equals("ID")) {
            try {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * from teacher where teacher_id='" + rule + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (type.equals("姓名")) {
            try {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * from teacher where teacher_name like '" + "%"+ rule+ "%" + "';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    private static String setDefaultPassword() {
        return "111111";
    }

}
