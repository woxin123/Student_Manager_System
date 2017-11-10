package com.example.web.contrall;

import com.example.domain.Teacher;
import com.example.service.TeacherService;
import com.example.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetTeacherMessage", urlPatterns = "/GetTeacherMessage")
public class GetTeacherMessage extends HttpServlet {
    private static final long serialVersionUID = -8640672744355140L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = request.getParameter("teacherId");
        TeacherService service = new TeacherServiceImpl();
        Teacher teacher = service.findTeacher(teacherId);
        if (teacher == null) {
            PrintWriter out = response.getWriter();
            out.println("出错了");
        } else {
            request.setAttribute("teacher", teacher);
            request.getRequestDispatcher(request.getContextPath() + "/admin/modifyteacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
