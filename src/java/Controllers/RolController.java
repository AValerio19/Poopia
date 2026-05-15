package Controllers;

import DAO.RolDAO;
import Models.RolModel;
import java.util.List;

public class RolController {
    private RolDAO dao;

    public RolController() {
        this.dao = new RolDAO();
    }

    public String registrarRol(String nombreRol) {
        if (nombreRol == null || nombreRol.trim().isEmpty()) {
            return "Error: El nombre del rol no puede estar vacío.";
        }
        RolModel nuevo = new RolModel();
        nuevo.setNombreRol(nombreRol);
        
        if (dao.insertar(nuevo)) {
            return "Éxito: Rol registrado correctamente.";
        } else {
            return "Error: No se pudo registrar el rol.";
        }
    }

    public List<RolModel> obtenerTodosLosRoles() {
        return dao.listarTodos();
    }

    public String editarRol(int id, String nombreRol) {
        if (nombreRol == null || nombreRol.trim().isEmpty()) {
            return "Error: El nombre del rol no puede estar vacío.";
        }
        RolModel existente = dao.buscarPorId(id);
        if (existente == null) {
            return "Error: El rol con ID " + id + " no existe.";
        }
        existente.setNombreRol(nombreRol);

        if (dao.actualizar(existente)) {
            return "Éxito: Rol actualizado.";
        } else {
            return "Error: No se pudo actualizar el rol.";
        }
    }

    public String borrarRol(int id) {
        if (dao.eliminar(id)) {
            return "Éxito: Rol eliminado.";
        } else {
            return "Error: No se pudo eliminar el rol.";
        }
    }
}
