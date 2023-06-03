package org.alibek.ls13.servlet;

import org.alibek.ls13.entity.Student;
import org.alibek.ls13.service.DbService;
import org.alibek.ls13.service.DbServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( value = "/student")
public class StudentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = DbServiceImpl.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("student.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {

    }
}
