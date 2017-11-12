package com.example.web.contrall;

import com.example.dao.Manager;
import com.example.dao.ManagerTeacher;
import com.example.daoImp.ManagerImpl;
import com.example.daoImp.ManagerTeacherImpl;
import com.example.domain.Admin;
import com.example.domain.Teacher;
import com.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 5381470083951632450L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        String type = request.getParameter("type");
        String verification = request.getParameter("verification");
        String yanzhengma = (String) request.getSession().getAttribute("piccode");
        System.out.println(yanzhengma);
        System.out.println(user.getUsername() + user.getPassword());
        Map<String, String> errors = new HashMap<>();
        boolean isOk = false;
        if (type.equals("学生")) {

        } else if (type.equals("老师")) {
            ManagerTeacher mantea = new ManagerTeacherImpl();
            if (mantea.find(user.getUsername()) == null) {
                errors.put("username", "用户不存在");
            } else {
                Teacher teacher = mantea.find(user.getUsername(), user.getPassword());
                if (teacher == null) {
                    errors.put("password", "密码错误");
                } else if (!yanzhengma.equals(verification)) {
                    errors.put("verification", "验证码错误");
                } else
                    isOk = true;
            }
        } else if (type.equals("管理员")) {
            Manager manager = new ManagerImpl();
            if (manager.find(user.getUsername()) == null) {
                errors.put("username", "用户不存在!");
            } else {
                Admin admin = manager.find(user.getUsername(), user.getPassword());
                if (admin == null) {
                    errors.put("password", "密码错误!");
                } else if (!yanzhengma.equals(verification)) {
                    errors.put("verification", "验证码错误");
                } else
                    isOk = true;
            }
        }
        if (isOk == false) {
            request.setAttribute("user", user);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);
        } else {
            response.sendRedirect("admin/manager.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
