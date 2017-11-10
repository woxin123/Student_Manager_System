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

@WebServlet(name = "AddClass", urlPatterns = "/AddClass")
public class AddClass extends HttpServlet {
    private static final long serialVersionUID = 5385588558053786760L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MyClass myclass = new MyClass();
        myclass.setClassId(request.getParameter("classId"));
        myclass.setClassName(request.getParameter("className"));
        myclass.setClassCollege(request.getParameter("classCollege"));
        myclass.setClassMajor(request.getParameter("classMajor"));
        myclass.setTime(request.getParameter("classTime"));
        ClassService classService = new ClassServiceImpl();
        if (classService.addClass(myclass)) {
            request.getRequestDispatcher("/admin/addclass.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "错误");
            request.getRequestDispatcher("/admin/addclass.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
