package InterfazDAO;

import Models.ResenaModel;
import java.util.List;

public interface IntResenaDAO {
    boolean insertar(ResenaModel resena);
    boolean actualizar(ResenaModel resena);
    boolean eliminar(int id);
    ResenaModel buscarPorId(int id);
    List<ResenaModel> listarTodos();
    List<ResenaModel> listarPorContenidoId(int contenidoId);
}
