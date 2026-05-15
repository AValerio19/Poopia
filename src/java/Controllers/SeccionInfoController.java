package Controllers;

import DAO.SeccionInfoDAO;
import Models.SeccionInfoModel;
import java.util.List;

public class SeccionInfoController {
    private SeccionInfoDAO dao;

    public SeccionInfoController() {
        this.dao = new SeccionInfoDAO();
    }

    public List<SeccionInfoModel> obtenerSeccionesPorContenidoId(int contenidoId) {
        return dao.obtenerSeccionesPorContenidoId(contenidoId);
    }

    public SeccionInfoModel obtenerSeccionPorId(int id) {
        return dao.buscarPorId(id);
    }
}
