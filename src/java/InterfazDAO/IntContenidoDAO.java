/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InterfazDAO;
import java.util.*;
import Models.ContenidoModel;

public interface IntContenidoDAO {
    boolean insertar(ContenidoModel contenido);
    boolean actualizar(ContenidoModel contenido);
    boolean eliminar(int id);
    ContenidoModel buscarPorId(int id);
    List<ContenidoModel> listarTodos();
}
