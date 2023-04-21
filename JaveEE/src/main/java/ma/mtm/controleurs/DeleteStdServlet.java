package ma.mtm.controleurs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.mtm.service.StudentService;

import java.io.IOException;

@WebServlet(value = "/DeleteStdServlet/*")
public class DeleteStdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String studentId = pathParts[1];
        StudentService stdserv = new StudentService();
        stdserv.delete(Integer.parseInt(studentId));
        response.sendRedirect(request.getContextPath() + "/Student"); // redirect to list of students page
    }
}
