package Servlets;

import Controllers.ContenidoController;
import Controllers.SeccionInfoController;
import Models.ContenidoModel;
import Models.SeccionInfoModel;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadServlet", urlPatterns = {"/ReadServlet"})
public class ReadServlet extends HttpServlet {

    private ContenidoController contenidoController = new ContenidoController();
    private SeccionInfoController seccionInfoController = new SeccionInfoController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                ContenidoModel readingBook = contenidoController.obtenerContenidoPorId(id);
                
                if (readingBook != null) {
                    request.setAttribute("readingBook", readingBook);
                    
                    // Fetch sections for the table of contents
                    List<SeccionInfoModel> secciones = seccionInfoController.obtenerSeccionesPorContenidoId(id);
                    request.setAttribute("listaSecciones", secciones);
                    
                    // Check if a specific section is selected
                    String seccionIdParam = request.getParameter("seccionId");
                    SeccionInfoModel seccionSeleccionada = null;
                    
                    if (seccionIdParam != null && !seccionIdParam.isEmpty()) {
                        int seccionId = Integer.parseInt(seccionIdParam);
                        seccionSeleccionada = seccionInfoController.obtenerSeccionPorId(seccionId);
                    } else if (!secciones.isEmpty()) {
                        // Default to the first section
                        seccionSeleccionada = secciones.get(0);
                    }
                    
                    request.setAttribute("seccionSeleccionada", seccionSeleccionada);
                }
            } catch (NumberFormatException e) {
                // Invalid ID
            }
        }
        
        // Configure the view
        request.setAttribute("viewToLoad", "/WEB-INF/Views/Reading.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
