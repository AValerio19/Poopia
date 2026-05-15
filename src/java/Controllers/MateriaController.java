package Controllers;

import DAO.MateriaDAO;
import Models.MateriaModel;
import java.util.List;

public class MateriaController {
    private MateriaDAO dao;

    public MateriaController() {
        this.dao = new MateriaDAO();
    }

    public String registrarMateria(String nombreMateria) {
        if (nombreMateria == null || nombreMateria.trim().isEmpty()) {
            return "Error: El nombre de la materia no puede estar vacío.";
        }
        MateriaModel nuevo = new MateriaModel();
        nuevo.setNombreMateria(nombreMateria);

        if (dao.insertar(nuevo)) {
            return "Éxito: Materia registrada correctamente.";
        } else {
            return "Error: No se pudo registrar la materia.";
        }
    }

    public List<MateriaModel> obtenerTodasLasMaterias() {
        return dao.listarTodos();
    }

    public String editarMateria(int id, String nombreMateria) {
        MateriaModel existente = dao.buscarPorId(id);
        if (existente == null) {
            return "Error: La materia con ID " + id + " no existe.";
        }
        existente.setNombreMateria(nombreMateria);

        if (dao.actualizar(existente)) {
            return "Éxito: Materia actualizada.";
        } else {
            return "Error: No se pudo actualizar la materia.";
        }
    }

    public String borrarMateria(int id) {
        if (dao.eliminar(id)) {
            return "Éxito: Materia eliminada.";
        } else {
            return "Error: No se pudo eliminar la materia.";
        }
    }
}
