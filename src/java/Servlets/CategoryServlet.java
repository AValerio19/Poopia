package Servlets;

import Controllers.ContenidoController;
import Controllers.MateriaController;
import Models.ContenidoModel;
import Models.MateriaModel;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/CategoryServlet"})
public class CategoryServlet extends HttpServlet {

    private ContenidoController contenidoController = new ContenidoController();
    private MateriaController materiaController = new MateriaController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<ContenidoModel> listaContenidos = contenidoController.obtenerTodoElContenido();
        List<MateriaModel> listaMaterias = materiaController.obtenerTodasLasMaterias();
        
        request.setAttribute("listaContenidos", listaContenidos);
        request.setAttribute("listaMaterias", listaMaterias);
        request.setAttribute("viewToLoad", "/WEB-INF/Views/Category.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
