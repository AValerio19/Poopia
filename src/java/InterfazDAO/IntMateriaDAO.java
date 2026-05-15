package InterfazDAO;

import Models.MateriaModel;
import java.util.List;

public interface IntMateriaDAO {
    boolean insertar(MateriaModel materia);
    boolean actualizar(MateriaModel materia);
    boolean eliminar(int id);
    MateriaModel buscarPorId(int id);
    List<MateriaModel> listarTodos();
}
