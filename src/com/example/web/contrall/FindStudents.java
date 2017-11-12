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
import java.util.List;

@WebServlet(name = "FindStudents", urlPatterns = "/FindStudents")
public class FindStudents extends HttpServlet {
    private static final long serialVersionUID = -723821755775284100L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String type = request.getParameter("type");
        StudentService service = new StudentServiceImpl();
        List<Student> findSomeStudents = service.findSomeStudent(role, type);
        request.setAttribute("findSomeStudent", findSomeStudents);
        request.getRequestDispatcher("admin/resultfindstudent.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
