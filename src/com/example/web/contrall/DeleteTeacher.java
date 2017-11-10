package com.example.web.contrall;

import com.example.dao.ManagerTeacher;
import com.example.daoImp.ManagerTeacherImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DeleteTeacher", urlPatterns = "/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
    private static final long serialVersionUID = 1705519654999139409L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String teacherId = request.getParameter("teacherId");
        ManagerTeacher manTea = new ManagerTeacherImpl();
        System.out.println(teacherId);
        Map<String, String> errors = new HashMap<>();
        if (manTea.find(teacherId) != null) {
            boolean isOK = manTea.deleteTeacher(teacherId);
            if (isOK == false)
                errors.put("error", "删除错误");
        } else {
            errors.put("teacherId", "用户不存在");
        }
        response.sendRedirect(request.getContextPath() + "/admin/allteacher.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
