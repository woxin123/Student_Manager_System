package com.example.web.contrall;

import com.example.service.ClassService;
import com.example.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteClass", urlPatterns = "/DeleteClass")
public class DeleteClass extends HttpServlet {
    private static final long serialVersionUID = 1919664582580015117L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService service = new ClassServiceImpl();
        String classId = request.getParameter("classId");
        if (service.deleteClass(classId)) {
            response.sendRedirect("/AllClass");
        } else {
            // 处理错误
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
