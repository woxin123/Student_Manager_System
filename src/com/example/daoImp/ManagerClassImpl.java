package com.example.daoImp;

import com.example.dao.ManagerClass;
import com.example.domain.MyClass;
import com.example.utils.MySQLCoonnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ManagerClassImpl implements ManagerClass {
    @Override
    public boolean addClass(MyClass myclass) {
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("insert into class " +
                    "VALUE (?, ?, ?, ?,? ,?)");
            pstmt.setString(1, myclass.getClassId());
            pstmt.setString(2, myclass.getClassName());
            pstmt.setString(3, myclass.getClassCollege());
            pstmt.setString(4, myclass.getClassMajor());
            pstmt.setString(5, myclass.getTime());
            pstmt.setInt(6, 0);
//            Statement stmt = conn.createStatement();
//            stmt.executeQuery("select student_id from class , student where student.class_id = '" + myclass.getClassId() +"';");
            pstmt.setInt(6, myclass.getTotal());
            pstmt.execute();
            isOK = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return isOK;
    }

    @Override
    public boolean deleteClass(String classId) {
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("delete from class where class_id='" + classId + "';");
            isOK = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return isOK;
    }

    /**
     * @param role 查询的字符串
     * @param type 查询的类型
     *             classId ID
     *             className 班级名称
     * @return
     */
    @Override
    public MyClass findClass(String role, String type) {
        MyClass myClass = null;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        System.out.println("aaaa");
        try {
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            if (type.equals("classId")) {
                rs = stmt.executeQuery("select * from class where class_id='" + role + "';");
                System.out.println(role);
            } else if (type.equals("className")) {
                rs = stmt.executeQuery("SELECT * from class where class_name='" + role + "';");
            }
            if (rs.next()) {
                myClass = new MyClass();
                myClass.setClassId(rs.getString(1));
                myClass.setClassName(rs.getString(2));
                myClass.setClassCollege(rs.getString(3));
                myClass.setClassMajor(rs.getString(4));
                myClass.setTime(rs.getString(5));
                myClass.setTotal(rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        mysql.Close();
        return myClass;
    }

    @Override
    public boolean modifyClass(MyClass myclass) {
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE class set class_name=?, " +
                    "class_college=?, class_major=?, class_time= ? " +
                    "WHERE class_id='" + myclass.getClassId() + "';");
            pstmt.setString(1, myclass.getClassName());
            pstmt.setString(2, myclass.getClassCollege());
            pstmt.setString(3, myclass.getClassMajor());
            pstmt.setString(4, myclass.getTime());
            pstmt.execute();
            isOK = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public boolean addClassStudent(String classId) {
        int total = studentTotal(classId);
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE class set class_total=" + (total + 1) + ";");
            isOK = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public boolean minusClassStudent(String classId) {
        int total = studentTotal(classId);
        boolean isOK = false;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE class set class_total=" + (total - 1) + ";");
            isOK = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isOK;
    }

    @Override
    public List<MyClass> allClass() {
        List<MyClass> allClass = new LinkedList<>();
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM class;");
            while (rs.next()) {
                MyClass myClass = new MyClass();
                myClass.setClassId(rs.getString(1));
                myClass.setClassName(rs.getString(2));
                myClass.setClassCollege(rs.getString(3));
                myClass.setClassMajor(rs.getString(4));
                myClass.setTime(rs.getString(5));
                myClass.setTotal(rs.getInt(6));
                allClass.add(myClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allClass;
    }

    @Override
    public List<MyClass> findSomeClass(String role, String type) {
        List<MyClass> listClass = new LinkedList<>();
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            ResultSet rs = null;
            Statement stmt = conn.createStatement();
            if (type.equals("ID")) {
                rs = stmt.executeQuery("SELECT * from class where class_id='" + role + "';");
            } else if (type.equals("名称")) {
                rs = stmt.executeQuery("SELECT * from class where class_name='" + role + "';");
            } else if (type.equals("学院")) {
                rs = stmt.executeQuery("SELECT * from class where class_college='" + role + "';");
            } else if (type.equals("专业")) {
                rs = stmt.executeQuery("SELECT * from class where class_major='" + role + "';");
            } else if (type.equals("创建时间")) {
                rs = stmt.executeQuery("SELECT * from class where class_time='" + role + "';");
            }
            while (rs.next()) {
                MyClass myClass = new MyClass();
                myClass.setClassId(rs.getString(1));
                myClass.setClassName(rs.getString(2));
                myClass.setClassCollege(rs.getString(3));
                myClass.setClassMajor(rs.getString(4));
                myClass.setTime(rs.getString(5));
                myClass.setTotal(rs.getInt(6));
                listClass.add(myClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClass;
    }

    private static int studentTotal(String classId) {
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select class_total from class WHERE class_id='" + classId + "';");
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
