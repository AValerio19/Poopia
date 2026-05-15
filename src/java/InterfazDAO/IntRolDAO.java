package InterfazDAO;

import Models.RolModel;
import java.util.List;

public interface IntRolDAO {
    boolean insertar(RolModel rol);
    boolean actualizar(RolModel rol);
    boolean eliminar(int id);
    RolModel buscarPorId(int id);
    List<RolModel> listarTodos();
}
