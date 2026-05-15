package DAO;

import Config.DbCon;
import InterfazDAO.IntGuardadoDAO;
import Models.GuardadoModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuardadoDAO implements IntGuardadoDAO {

    @Override
    public boolean insertar(GuardadoModel guardado) {
        String sql = "INSERT INTO guardados (usuario_id, contenido_id) VALUES (?, ?)";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, guardado.getUsuarioId());
            ps.setInt(2, guardado.getContenidoId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int usuarioId, int contenidoId) {
        String sql = "DELETE FROM guardados WHERE usuario_id = ? AND contenido_id = ?";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ps.setInt(2, contenidoId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<GuardadoModel> listarPorUsuarioId(int usuarioId) {
        List<GuardadoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM guardados WHERE usuario_id = ?";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    GuardadoModel guardado = new GuardadoModel();
                    guardado.setUsuarioId(rs.getInt("usuario_id"));
                    guardado.setContenidoId(rs.getInt("contenido_id"));
                    guardado.setFechaGuardado(rs.getTimestamp("fecha_guardado"));
                    lista.add(guardado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
