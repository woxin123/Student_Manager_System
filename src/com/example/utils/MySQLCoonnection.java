package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLCoonnection {
    // 数据库驱动
    private static String driver = "com.mysql.jdbc.Driver";
    // 数据库URL
    private static String url = "jdbc:mysql://localhost:3306/studentsystem";
    // user
    private static String user = "root";
    // 密码
    private static String pass = "mengchen0705";
    // 连接
    private static Connection conn = null;

    public MySQLCoonnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("获取数据库驱动错误");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("获取数据库连接错误");
            e.printStackTrace();
        }
        return conn;
    }

    public void Close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("关闭数据库错误");
                e.printStackTrace();
            }
        }
    }
}
