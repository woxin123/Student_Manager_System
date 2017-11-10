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

/**
 *
 */
@WebServlet(name = "AllClass", urlPatterns = "/AllClass")
public class AllClass extends HttpServlet {
    private static final long serialVersionUID = -7970640096321612922L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService service = new ClassServiceImpl();
        List<MyClass> myClasses = service.allTeacher();
        request.setAttribute("allClass", myClasses);
        request.getRequestDispatcher("admin/allclass.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
