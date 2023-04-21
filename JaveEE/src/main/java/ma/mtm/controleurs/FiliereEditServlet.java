package ma.mtm.controleurs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.mtm.classes.Filiere;
import ma.mtm.classes.Student;
import ma.mtm.service.FiliereService;
import ma.mtm.service.StudentService;

import java.io.IOException;

@WebServlet(name = "FiliereEditServlet", value = "/EditFil/Edit/*")
public class FiliereEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String filtId = pathParts[1];
        FiliereService filserver = new FiliereService();
        Filiere fil=filserver.findById(Integer.parseInt(filtId));
        request.setAttribute("fil",fil);
        request.getRequestDispatcher("/EditFil.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nom");
        System.out.println(name);
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String filieretId = pathParts[1];
        System.out.println(filieretId);
        FiliereService FilService = new FiliereService();
        Filiere newFiliere = new Filiere(name);
        FilService.update(newFiliere,Integer.parseInt(filieretId));
        response.sendRedirect(request.getContextPath() + "/Filiere");
    }
}
