package InterfazDAO;

import Models.UsuarioModel;
import java.util.List;

public interface IntUsuarioDAO {
    boolean insertar(UsuarioModel usuario);
    boolean actualizar(UsuarioModel usuario);
    boolean eliminar(int id);
    UsuarioModel buscarPorId(int id);
    UsuarioModel buscarPorCorreo(String correo);
    List<UsuarioModel> listarTodos();
}
