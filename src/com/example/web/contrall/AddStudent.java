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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddStudent", urlPatterns = "/AddStudent")
public class AddStudent extends HttpServlet {
    private static final long serialVersionUID = 5574232102716156421L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();
        Student student = new Student();
        String studentId = request.getParameter("studentId");
        if (studentId.equals("")) {
            errors.put("studentId", "Id不能为空");
        } else if (!StudentUtil.checkStudentId(studentId)) {
            errors.put("studentId", "Id不符合规则");
        }
        student.setStudentId(studentId);
        String studentName = request.getParameter("studentName");
        if (studentName.length() < 1) {
            errors.put("studentName", "该姓名太短");
        } else if (studentName.length() > 4) {
            errors.put("studetName", "该名称太长");
        } else
            student.setName(studentName);
        String studentGender = request.getParameter("studentGender");
        student.setGender(studentGender.charAt(0));
        int studentAge = Integer.parseInt(request.getParameter("studentAge"));
        if (studentAge < 0 || studentAge > 100) {
            errors.put("studentAge", "年龄符合要求");
        } else {
            student.setAge(studentAge);
        }
        String studentCollege = request.getParameter("studentCollege");
        if (studentCollege.equals("")) {
            errors.put("studentCollege", "学院不能为空");
        } else if (!StudentUtil.checkCollege(studentCollege)) {
            errors.put("studentCollege", "学院不合法");
        } else
            student.setCollege(studentCollege);
        String studentMajor = request.getParameter("studentMajor");
        if (studentMajor.equals("")) {
            errors.put("studentMajor", "专业不能为空");
        } else if (!StudentUtil.checkMajor(studentMajor)) {
            errors.put("studentMajor", "专业不合法");
        } else {
            student.setMajor(studentMajor);
        }
        String classId = request.getParameter("classId");
        if (classId.equals("")) {
            errors.put("classId", "班级不能为空");
        } else if (!StudentUtil.checkClass(classId)) {
            errors.put("classId", "班级不存在");
        } else
            student.setStudentClass(classId);
        String admissionDate = request.getParameter("admissionDate");
        if (admissionDate.equals("")) {
            errors.put("admissionDate", "入学时间不能为空");
        } else
            student.setAdmissionDate(admissionDate);
        String phone = request.getParameter("phone");
        if (phone.equals("")) {
            student.setPhone(null);
        }
        String address = request.getParameter("address");
        if (address.equals(""))
            student.setAddress(null);
        else
            student.setAddress(address);
        String dormitory = request.getParameter("dormitory");
        if (dormitory.equals(""))
            student.setDormitory(null);
        else
            student.setDormitory(dormitory);
        if (errors.isEmpty()) {
            StudentService service = new StudentServiceImpl();
            service.addStudent(student);
            request.getRequestDispatcher("/admin/addstudent.jsp").forward(request, response);
        } else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/admin/addstudent.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
