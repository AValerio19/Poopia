package Servlets;

import Controllers.ContenidoController;
import Controllers.MateriaController;
import Models.ContenidoModel;
import Models.MateriaModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "DiscoverServlet", urlPatterns = {"/DiscoverServlet"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class DiscoverServlet extends HttpServlet {

    private ContenidoController contenidoController = new ContenidoController();
    private MateriaController materiaController = new MateriaController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<ContenidoModel> listaContenidos = contenidoController.obtenerTodoElContenido();
        List<MateriaModel> listaMaterias = materiaController.obtenerTodasLasMaterias();
        
        request.setAttribute("listaContenidos", listaContenidos);
        request.setAttribute("listaMaterias", listaMaterias);
        
        request.setAttribute("viewToLoad", "/WEB-INF/Views/Discover.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        
        if (action != null) {
            try {
                if (action.equals("add") || action.equals("edit")) {
                    String titulo = request.getParameter("titulo");
                    String publicador = request.getParameter("publicador");
                    String fechaStr = request.getParameter("fecha");
                    String cuerpo = request.getParameter("cuerpo");
                    
                    Date fecha = null;
                    if (fechaStr != null && !fechaStr.isEmpty()) {
                        fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
                    } else {
                        fecha = new Date(); // Default to now
                    }
                    
                    // Manejo de la subida de archivo
                    Part filePart = request.getPart("imagenFile");
                    String url = "";
                    
                    if (filePart != null && filePart.getSize() > 0) {
                        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                        // Guardar la imagen en el directorio de Assets
                        String uploadPath = request.getServletContext().getRealPath("") + File.separator + "Assets" + File.separator + "Img" + File.separator + "Books";
                        File uploadDir = new File(uploadPath);
                        if (!uploadDir.exists()) uploadDir.mkdirs();
                        
                        filePart.write(uploadPath + File.separator + fileName);
                        url = fileName;
                    }

                    if (action.equals("add")) {
                        int materiaId = Integer.parseInt(request.getParameter("materiaId"));
                        if (url.isEmpty()) url = "default.jpg"; // Imagen por defecto si no suben nada
                        contenidoController.registrarContenido(materiaId, titulo, publicador, fecha, cuerpo, url);
                        
                    } else if (action.equals("edit")) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        // Si no subió imagen nueva, usar la URL actual que pasamos en un input oculto
                        if (url.isEmpty()) {
                            url = request.getParameter("url_actual");
                        }
                        contenidoController.editarContenido(id, titulo, publicador, fecha, cuerpo, url);
                    }
                } else if (action.equals("delete")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    contenidoController.borrarContenido(id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        response.sendRedirect("main?p=discover");
    }
}
