/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import Models.ContenidoModel;
import DAO.ContenidoDAO;
import java.util.List;

public class ContenidoController {
    private ContenidoDAO dao;

    public ContenidoController() {
        this.dao = new ContenidoDAO();
    }

    // 1. MÉTODO PARA REGISTRAR (Con validaciones)
    public String registrarContenido(int materiaId, String titulo, String publicador, 
                                    java.util.Date fecha, String cuerpo, String url) {
        
        // Validación de ciberseguridad básica: Evitar campos vacíos
        if (titulo.isEmpty() || cuerpo.isEmpty()) {
            return "Error: El título y el contenido son obligatorios.";
        }

        ContenidoModel nuevo = new ContenidoModel();
        nuevo.setMateriaId(materiaId);
        nuevo.setTitulo(titulo);
        nuevo.setPublicador(publicador);
        nuevo.setFechaPublicacion(fecha);
        nuevo.setCuerpoTexto(cuerpo);
        nuevo.setImagenUrl(url);

        if (dao.insertar(nuevo)) {
            return "Éxito: Contenido registrado correctamente.";
        } else {
            return "Error: No se pudo guardar en la base de datos.";
        }
    }

    // 2. MÉTODO PARA LISTAR (Para llenar tus tablas en la UI)
    public List<ContenidoModel> obtenerTodoElContenido() {
        return dao.listarTodos();
    }

    public ContenidoModel obtenerContenidoPorId(int id) {
        return dao.buscarPorId(id);
    }

    // 3. MÉTODO PARA ACTUALIZAR
    public String editarContenido(int id, String titulo, String publicador, 
                                 java.util.Date fecha, String cuerpo, String url) {
        
        // Primero verificamos que el contenido exista
        ContenidoModel existente = dao.buscarPorId(id);
        if (existente == null) {
            return "Error: El contenido con ID " + id + " no existe.";
        }

        existente.setTitulo(titulo);
        existente.setPublicador(publicador);
        existente.setFechaPublicacion(fecha);
        existente.setCuerpoTexto(cuerpo);
        existente.setImagenUrl(url);

        if (dao.actualizar(existente)) {
            return "Éxito: Contenido actualizado.";
        } else {
            return "Error: No se pudo actualizar.";
        }
    }

    // 4. MÉTODO PARA ELIMINAR
    public String borrarContenido(int id) {
        if (dao.eliminar(id)) { 
            return "Éxito: Contenido eliminado.";
        } else {
            return "Error: El contenido no pudo ser borrado.";
        }
    }
}
