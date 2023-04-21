package ma.mtm.controleurs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.mtm.classes.Filiere;
import ma.mtm.service.FiliereService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FiliereServlet", value = "/Filiere")
public class FiliereServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Filiere> fils;
        FiliereService flservices = new FiliereService();
        fils = flservices.findAll();
        request.setAttribute("fils",fils);
        request.getRequestDispatcher("/Filiere.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
