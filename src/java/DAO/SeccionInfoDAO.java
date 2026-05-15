package DAO;

import java.sql.*;
import java.util.*;
import Config.DbCon;
import InterfazDAO.IntSeccionInfoDAO;
import Models.SeccionInfoModel;

public class SeccionInfoDAO implements IntSeccionInfoDAO {

    @Override
    public List<SeccionInfoModel> obtenerSeccionesPorContenidoId(int contenidoId) {
        List<SeccionInfoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM secciones_info WHERE contenido_id = ? ORDER BY orden ASC";

        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, contenidoId);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    SeccionInfoModel seccion = new SeccionInfoModel();
                    seccion.setId(rs.getInt("id"));
                    seccion.setContenidoId(rs.getInt("contenido_id"));
                    seccion.setSubtitulo(rs.getString("subtitulo"));
                    seccion.setCuerpoTexto(rs.getString("cuerpo_texto"));
                    seccion.setOrden(rs.getInt("orden"));
                    lista.add(seccion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public SeccionInfoModel buscarPorId(int id) {
        String sql = "SELECT * FROM secciones_info WHERE id = ?";
        SeccionInfoModel seccion = null;

        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    seccion = new SeccionInfoModel();
                    seccion.setId(rs.getInt("id"));
                    seccion.setContenidoId(rs.getInt("contenido_id"));
                    seccion.setSubtitulo(rs.getString("subtitulo"));
                    seccion.setCuerpoTexto(rs.getString("cuerpo_texto"));
                    seccion.setOrden(rs.getInt("orden"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return seccion;
    }
}
