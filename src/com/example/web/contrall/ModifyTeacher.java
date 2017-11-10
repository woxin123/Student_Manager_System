package com.example.web.contrall;

import com.example.domain.Teacher;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import com.example.service.impl.StudentServiceImpl;
import com.example.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ModifyTeacher", urlPatterns = "/ModifyTeacher")
public class ModifyTeacher extends HttpServlet {
    private static final long serialVersionUID = 6663014111437472824L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(request.getParameter("teacherId"));
        System.out.println(teacher.getTeacherId());
        teacher.setName(request.getParameter("teacherName"));
        System.out.println(teacher.getName());
        teacher.setAge(Integer.valueOf(request.getParameter("teacherAge")));
        System.out.println(teacher.getAge());
        teacher.setGender(request.getParameter("teacherGender").charAt(0));
        System.out.println(teacher.getGender());
        teacher.setCollege(request.getParameter("teacherCollege"));
        System.out.println(teacher.getCollege());
        teacher.setPhone(request.getParameter("teacherPhone"));
        System.out.println(teacher.getPhone());
        teacher.setIntroduce(request.getParameter("teacherIntroduce"));
        System.out.println(teacher.getIntroduce());
        TeacherService service = new TeacherServiceImpl();
        if (service.modifyTeacher(teacher)) {
            request.getRequestDispatcher("admin/allteacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
