package ma.mtm.controleurs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.mtm.classes.Filiere;
import ma.mtm.classes.Student;
import ma.mtm.service.FiliereService;
import ma.mtm.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Student", value = "/EditStd/Edit/*")
public class StudentEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String studentId = pathParts[1];
        StudentService std = new StudentService();
        Student student=std.findById(Integer.parseInt(studentId));
        // all majors
        List<Filiere> fils;
        FiliereService flservices = new FiliereService();
        fils = flservices.findAll();
        System.out.println(fils);
        request.setAttribute("fils",fils);
        request.setAttribute("std",student);
        request.getRequestDispatcher("/EditStd.jsp").forward(request,response);
        request.getRequestDispatcher("/EditStd.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nom");
        String lastName = request.getParameter("prenom");
        String sex = request.getParameter("sexe");
        String filiere = request.getParameter("Fil");

        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String studentId = pathParts[1];
        StudentService studentService = new StudentService();
        Student student = new Student(name, lastName, sex, filiere);
        studentService.update(student,Integer.parseInt(studentId));
        response.sendRedirect(request.getContextPath() + "/Student");
    }
}
