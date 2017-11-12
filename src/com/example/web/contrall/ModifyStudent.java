package com.example.web.contrall;

import com.example.domain.Student;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;
import com.example.utils.StudentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ModifyStudent", urlPatterns = "/ModifyStudent")
public class ModifyStudent extends HttpServlet {
    private static final long serialVersionUID = -806277060025673579L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentUtil util = new StudentUtil();
        Student student = util.toBean(request);
        if (student == null) {
            request.getRequestDispatcher("admin/modifystudent.jsp").forward(request,response);
        } else {
            StudentService service = new StudentServiceImpl();
            if(service.modify(student)) {
                request.getRequestDispatcher("/AllStudent").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("出错");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
