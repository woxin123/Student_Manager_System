package com.example.daoImp;

import com.example.dao.Manager;
import com.example.domain.Admin;
import com.example.utils.MySQLCoonnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerImpl implements Manager {
    @Override
    public Admin find(String adminName) {
        Admin admin = null;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin" +
                    " where admin_username='" + adminName + "';");
            if (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getString(1));
                admin.setAdminUsername(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public Admin find(String adminName, String adminPassword) {
        Admin admin = null;
        MySQLCoonnection mysql = new MySQLCoonnection();
        Connection conn = mysql.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from admin" +
                    " where admin_username='" + adminName + "'and admin_password='" + adminPassword + "';");
            if (rs.next()) {
                admin = new Admin();
                admin.setAdminId(rs.getString(1));
                admin.setAdminUsername(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
