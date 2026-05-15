package InterfazDAO;

import Models.GuardadoModel;
import java.util.List;

public interface IntGuardadoDAO {
    boolean insertar(GuardadoModel guardado);
    boolean eliminar(int usuarioId, int contenidoId);
    List<GuardadoModel> listarPorUsuarioId(int usuarioId);
}
