package DAO;

import Config.DbCon;
import InterfazDAO.IntResenaDAO;
import Models.ResenaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResenaDAO implements IntResenaDAO {

    @Override
    public boolean insertar(ResenaModel resena) {
        String sql = "INSERT INTO resenas (usuario_id, contenido_id, estrellas, comentario) VALUES (?, ?, ?, ?)";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, resena.getUsuarioId());
            ps.setInt(2, resena.getContenidoId());
            ps.setInt(3, resena.getEstrellas());
            ps.setString(4, resena.getComentario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(ResenaModel resena) {
        String sql = "UPDATE resenas SET estrellas = ?, comentario = ? WHERE id = ?";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, resena.getEstrellas());
            ps.setString(2, resena.getComentario());
            ps.setInt(3, resena.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM resenas WHERE id = ?";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ResenaModel buscarPorId(int id) {
        String sql = "SELECT * FROM resenas WHERE id = ?";
        ResenaModel resena = null;
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    resena = new ResenaModel();
                    resena.setId(rs.getInt("id"));
                    resena.setUsuarioId(rs.getInt("usuario_id"));
                    resena.setContenidoId(rs.getInt("contenido_id"));
                    resena.setEstrellas(rs.getInt("estrellas"));
                    resena.setComentario(rs.getString("comentario"));
                    resena.setFechaResena(rs.getTimestamp("fecha_resena"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resena;
    }

    @Override
    public List<ResenaModel> listarTodos() {
        List<ResenaModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM resenas";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ResenaModel resena = new ResenaModel();
                resena.setId(rs.getInt("id"));
                resena.setUsuarioId(rs.getInt("usuario_id"));
                resena.setContenidoId(rs.getInt("contenido_id"));
                resena.setEstrellas(rs.getInt("estrellas"));
                resena.setComentario(rs.getString("comentario"));
                resena.setFechaResena(rs.getTimestamp("fecha_resena"));
                lista.add(resena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<ResenaModel> listarPorContenidoId(int contenidoId) {
        List<ResenaModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM resenas WHERE contenido_id = ?";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, contenidoId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ResenaModel resena = new ResenaModel();
                    resena.setId(rs.getInt("id"));
                    resena.setUsuarioId(rs.getInt("usuario_id"));
                    resena.setContenidoId(rs.getInt("contenido_id"));
                    resena.setEstrellas(rs.getInt("estrellas"));
                    resena.setComentario(rs.getString("comentario"));
                    resena.setFechaResena(rs.getTimestamp("fecha_resena"));
                    lista.add(resena);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
