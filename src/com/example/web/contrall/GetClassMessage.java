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

@WebServlet(name = "GetClassMessage", urlPatterns = {"/GetModifyClassMessage"})
public class GetClassMessage extends HttpServlet {
    private static final long serialVersionUID = -365670013036164591L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        String classId = request.getParameter("classId");
        ClassService service = new ClassServiceImpl();
        MyClass myclass = service.findClass(classId, "classId");
        request.setAttribute("MyClass", myclass);
        System.out.println(myclass.getClassId());
        if (action.equals("GetModifyClassMessage")) {
            request.getRequestDispatcher("admin/modifyclass.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
