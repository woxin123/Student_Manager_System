package com.example.dao;

import com.example.domain.Admin;

public interface Manager {
    Admin find(String adminName);
    Admin find(String adminName, String adminPassword);
}
