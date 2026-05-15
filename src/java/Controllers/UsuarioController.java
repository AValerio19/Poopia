package Controllers;

import DAO.UsuarioDAO;
import Models.UsuarioModel;
import java.util.List;

public class UsuarioController {
    private UsuarioDAO dao;

    public UsuarioController() {
        this.dao = new UsuarioDAO();
    }

    public String registrarUsuario(String nombre, String correo, String contrasena, int rolId) {
        if (nombre == null || nombre.isEmpty() || correo == null || correo.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            return "Error: Todos los campos obligatorios deben estar llenos.";
        }
        
        UsuarioModel nuevo = new UsuarioModel();
        nuevo.setNombre(nombre);
        nuevo.setCorreo(correo);
        // NOTA: Para producción, la contraseña DEBE estar hasheada (p.ej. usando BCrypt) antes de guardarla
        nuevo.setContrasena(contrasena); 
        nuevo.setRolId(rolId);

        if (dao.insertar(nuevo)) {
            return "Éxito: Usuario registrado correctamente.";
        } else {
            return "Error: No se pudo registrar el usuario. El correo podría ya estar en uso.";
        }
    }

    public List<UsuarioModel> obtenerTodosLosUsuarios() {
        return dao.listarTodos();
    }

    public String editarUsuario(int id, String nombre, String correo, String contrasena, int rolId) {
        UsuarioModel existente = dao.buscarPorId(id);
        if (existente == null) {
            return "Error: El usuario con ID " + id + " no existe.";
        }
        existente.setNombre(nombre);
        existente.setCorreo(correo);
        if (contrasena != null && !contrasena.isEmpty()) {
            existente.setContrasena(contrasena);
        }
        existente.setRolId(rolId);

        if (dao.actualizar(existente)) {
            return "Éxito: Usuario actualizado.";
        } else {
            return "Error: No se pudo actualizar el usuario.";
        }
    }

    public String borrarUsuario(int id) {
        if (dao.eliminar(id)) {
            return "Éxito: Usuario eliminado.";
        } else {
            return "Error: No se pudo eliminar el usuario.";
        }
    }
}
