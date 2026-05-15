package Controllers;

import DAO.ResenaDAO;
import Models.ResenaModel;
import java.util.List;

public class ResenaController {
    private ResenaDAO dao;

    public ResenaController() {
        this.dao = new ResenaDAO();
    }

    public String registrarResena(int usuarioId, int contenidoId, int estrellas, String comentario) {
        if (estrellas < 1 || estrellas > 5) {
            return "Error: Las estrellas deben estar entre 1 y 5.";
        }
        ResenaModel nueva = new ResenaModel();
        nueva.setUsuarioId(usuarioId);
        nueva.setContenidoId(contenidoId);
        nueva.setEstrellas(estrellas);
        nueva.setComentario(comentario);

        if (dao.insertar(nueva)) {
            return "Éxito: Reseña registrada correctamente.";
        } else {
            return "Error: No se pudo registrar la reseña. Podría existir ya una reseña para este usuario y contenido.";
        }
    }

    public List<ResenaModel> obtenerTodasLasResenas() {
        return dao.listarTodos();
    }

    public List<ResenaModel> obtenerResenasPorContenido(int contenidoId) {
        return dao.listarPorContenidoId(contenidoId);
    }

    public String editarResena(int id, int estrellas, String comentario) {
        if (estrellas < 1 || estrellas > 5) {
            return "Error: Las estrellas deben estar entre 1 y 5.";
        }
        ResenaModel existente = dao.buscarPorId(id);
        if (existente == null) {
            return "Error: La reseña con ID " + id + " no existe.";
        }
        existente.setEstrellas(estrellas);
        existente.setComentario(comentario);

        if (dao.actualizar(existente)) {
            return "Éxito: Reseña actualizada.";
        } else {
            return "Error: No se pudo actualizar la reseña.";
        }
    }

    public String borrarResena(int id) {
        if (dao.eliminar(id)) {
            return "Éxito: Reseña eliminada.";
        } else {
            return "Error: No se pudo eliminar la reseña.";
        }
    }
}
