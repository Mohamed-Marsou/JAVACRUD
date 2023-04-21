package ma.mtm.controleurs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.mtm.service.FiliereService;
import ma.mtm.service.StudentService;

import java.io.IOException;

@WebServlet(name = "DeleteFiliereServlet", value = "/DeleteFiliereServlet/*")
public class DeleteFiliereServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String FiltId = pathParts[1];
        FiliereService Filserv = new FiliereService();
        Filserv.delete(Integer.parseInt(FiltId));
        response.sendRedirect(request.getContextPath() + "/Filiere"); // redirect to list of Filieres page
    }
}
