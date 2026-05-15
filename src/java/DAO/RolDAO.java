package DAO;

import Config.DbCon;
import InterfazDAO.IntRolDAO;
import Models.RolModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements IntRolDAO {

    @Override
    public boolean insertar(RolModel rol) {
        String sql = "INSERT INTO roles (nombre_rol) VALUES (?)";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rol.getNombreRol());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(RolModel rol) {
        String sql = "UPDATE roles SET nombre_rol = ? WHERE id = ?";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rol.getNombreRol());
            ps.setInt(2, rol.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM roles WHERE id = ?";
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
    public RolModel buscarPorId(int id) {
        String sql = "SELECT * FROM roles WHERE id = ?";
        RolModel rol = null;
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    rol = new RolModel();
                    rol.setId(rs.getInt("id"));
                    rol.setNombreRol(rs.getString("nombre_rol"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rol;
    }

    @Override
    public List<RolModel> listarTodos() {
        List<RolModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RolModel rol = new RolModel();
                rol.setId(rs.getInt("id"));
                rol.setNombreRol(rs.getString("nombre_rol"));
                lista.add(rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
