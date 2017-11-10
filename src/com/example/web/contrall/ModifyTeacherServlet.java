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

@WebServlet(name = "ModifyTeacherServlet")
public class ModifyTeacherServlet extends HttpServlet {
    private static final long serialVersionUID = -1379923117841050107L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ManagerTeacher manTea = new ManagerTeacherImpl();
        Teacher teacher = new Teacher();
        teacher.setTeacherId(request.getParameter("teacherId"));
        teacher.setName(request.getParameter("teacherName"));
        teacher.setGender(request.getParameter("teacherGender").charAt(0));
        teacher.setAge(Integer.valueOf(request.getParameter("age")));
        teacher.setCollege(request.getParameter("college"));
        teacher.setPhone(request.getParameter("phone"));
        teacher.setIntroduce(request.getParameter("introduce"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
