package InterfazDAO;

import Models.SeccionInfoModel;
import java.util.List;

public interface IntSeccionInfoDAO {
    List<SeccionInfoModel> obtenerSeccionesPorContenidoId(int contenidoId);
    SeccionInfoModel buscarPorId(int id);
}
