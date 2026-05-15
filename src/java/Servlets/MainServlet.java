package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.ContenidoController;
import Controllers.MateriaController;
import Models.MateriaModel;
import Models.ContenidoModel;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    // Instancias de los controladores necesarios para la vista principal
    private MateriaController materiaController = new MateriaController();
    private ContenidoController contenidoController = new ContenidoController();
    // Aquí puedes agregar otros controladores en el futuro

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String mensaje;
        switch (action) {
            case "add":
                String nombreMateria = request.getParameter("nombreMateria");
                mensaje = materiaController.registrarMateria(nombreMateria);
                request.getSession().setAttribute("feedback", mensaje);
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("idMateria"));
                mensaje =materiaController.borrarMateria(id);
                request.getSession().setAttribute("feedback", mensaje);
                break;
            default:
                break;
        }

        response.sendRedirect("main");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Cargar los datos para la vista principal
        List<MateriaModel> listaMaterias = materiaController.obtenerTodasLasMaterias();
        request.setAttribute("listaMaterias", listaMaterias);
        
        List<ContenidoModel> listaContenidos = contenidoController.obtenerTodoElContenido();
        request.setAttribute("listaContenidos", listaContenidos);
        
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                ContenidoModel previewBook = contenidoController.obtenerContenidoPorId(id);
                if (previewBook != null) {
                    request.setAttribute("previewBook", previewBook);
                    request.setAttribute("selectedBookId", String.valueOf(id));
                }
            } catch (NumberFormatException e) {
                // Invalid ID format, ignore
            }
        }
        
        // Configurar la vista que index.jsp debe cargar
        request.setAttribute("viewToLoad", "/WEB-INF/Views/Main.jsp");
        
        // Redirigir a index.jsp para renderizar todo
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
