package Controllers;

import DAO.GuardadoDAO;
import Models.GuardadoModel;
import java.util.List;

public class GuardadoController {
    private GuardadoDAO dao;

    public GuardadoController() {
        this.dao = new GuardadoDAO();
    }

    public String guardarContenido(int usuarioId, int contenidoId) {
        GuardadoModel nuevo = new GuardadoModel();
        nuevo.setUsuarioId(usuarioId);
        nuevo.setContenidoId(contenidoId);

        if (dao.insertar(nuevo)) {
            return "Éxito: Contenido guardado a favoritos.";
        } else {
            return "Error: No se pudo guardar el contenido (quizás ya está guardado).";
        }
    }

    public String removerContenidoGuardado(int usuarioId, int contenidoId) {
        if (dao.eliminar(usuarioId, contenidoId)) {
            return "Éxito: Contenido removido de favoritos.";
        } else {
            return "Error: No se pudo remover el contenido.";
        }
    }

    public List<GuardadoModel> obtenerGuardadosPorUsuario(int usuarioId) {
        return dao.listarPorUsuarioId(usuarioId);
    }
}
