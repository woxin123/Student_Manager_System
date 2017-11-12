package com.example.web.contrall;

import com.example.domain.Student;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetStudentMessage", urlPatterns = {"/GetModifyStudentMessage"})
public class GetStudentMessage extends HttpServlet {
    private static final long serialVersionUID = 766492115327099303L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        String studentId = request.getParameter("studentId");
        StudentService service = new StudentServiceImpl();
        Student student = service.find(studentId);
        request.setAttribute("student", student);
        if (action.equals("GetModifyStudentMessage")) {
            request.getRequestDispatcher("admin/modifystudent.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
