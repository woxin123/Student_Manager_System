package com.example.web.contrall;

import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteStudet", urlPatterns = "/DeleteStudent")
public class DeleteStudet extends HttpServlet {
    private static final long serialVersionUID = -2099080444425433182L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService service = new StudentServiceImpl();
        String studentId = request.getParameter("studentId");
        if (service.deleteStudent(studentId)) {
            request.getRequestDispatcher("/AllStudent").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("出错");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
