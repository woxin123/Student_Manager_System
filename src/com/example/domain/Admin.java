package com.example.domain;

import java.io.Serializable;

public class Admin implements Serializable {

    private static final long serialVersionUID = 4295772241339696564L;
    // 管理员ID
    private String adminId;
    // 管理员用户名
    private String adminUsername;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }
}
