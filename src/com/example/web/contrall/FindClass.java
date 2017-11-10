package com.example.web.contrall;

import com.example.domain.MyClass;
import com.example.service.ClassService;
import com.example.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindClass", urlPatterns = "/FindClass")
public class FindClass extends HttpServlet {
    private static final long serialVersionUID = 4761788029613528690L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String type = request.getParameter("type");
        ClassService service = new ClassServiceImpl();
        List<MyClass> listClass = service.findSomeClass(role, type);
        request.setAttribute("listClass", listClass);
        request.getRequestDispatcher("admin/resultfindclass.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
