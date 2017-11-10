package com.example.web.contrall;

import com.example.dao.ManagerTeacher;
import com.example.daoImp.ManagerTeacherImpl;
import com.example.domain.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddTeacher", urlPatterns = "/AddTeacher")
public class AddTeacher extends HttpServlet {
    private static final long serialVersionUID = 6090266711463528021L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Teacher teacher = new Teacher();
        teacher.setTeacherId(request.getParameter("teacherId"));
        teacher.setName(request.getParameter("teachername"));
        teacher.setGender(request.getParameter("gender").charAt(0));
        teacher.setAge(Integer.valueOf(request.getParameter("age")));
        teacher.setCollege(request.getParameter("college"));
        teacher.setPhone(request.getParameter("phone"));
        teacher.setIntroduce(request.getParameter("introduce"));
        ManagerTeacher manTea = new ManagerTeacherImpl();
        boolean isOK = manTea.addTeacher(teacher);
        if (isOK) {
            request.getRequestDispatcher("/admin/manager.jsp").forward(request, response);
        } else {
            String message = "ID重复";
            request.setAttribute("message", message);
            request.getRequestDispatcher( "/admin/addteacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
