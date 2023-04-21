package ma.mtm.controleurs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.mtm.classes.Filiere;
import ma.mtm.classes.Student;
import ma.mtm.service.FiliereService;
import ma.mtm.service.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/Student")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> stds ;
        StudentService studentService = new StudentService();
        stds = studentService.findAll();
        request.setAttribute("stds",stds);

        List<Filiere> fils;
        FiliereService flservices = new FiliereService();
        fils = flservices.findAll();
        request.setAttribute("fils",fils);
        request.getRequestDispatcher("/Student.jsp").forward(request,response);
        request.getRequestDispatcher("/Student.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String sex = request.getParameter("sex");
        String filiere = request.getParameter("fil");

        StudentService studentService = new StudentService();


        Student student = new Student(name, lastName, sex, filiere);
        studentService.create(student);

        response.sendRedirect(request.getContextPath() + "/Student");
    }
}
