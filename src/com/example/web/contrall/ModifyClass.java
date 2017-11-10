package com.example.web.contrall;

import com.example.domain.MyClass;
import com.example.service.ClassService;
import com.example.service.impl.ClassServiceImpl;
import com.example.utils.ClassUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ModifyClass", urlPatterns = "/ModifyClass")
public class ModifyClass extends HttpServlet {
    private static final long serialVersionUID = 5657352207113405490L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassUtils classUtils = new ClassUtils();
        MyClass myClass = classUtils.toBean(request);
        ClassService service = new ClassServiceImpl();
        if (service.modifyClass(myClass)) {
            request.getRequestDispatcher("/AllClass").forward(request, response);
        } else {
            request.setAttribute("MyClass", myClass);
            request.getRequestDispatcher("admin/modifyclass.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
