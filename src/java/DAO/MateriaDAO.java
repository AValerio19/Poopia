package DAO;

import Config.DbCon;
import InterfazDAO.IntMateriaDAO;
import Models.MateriaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO implements IntMateriaDAO {

    @Override
    public boolean insertar(MateriaModel materia) {
        String sql = "INSERT INTO materias (nombre_materia) VALUES (?)";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, materia.getNombreMateria());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(MateriaModel materia) {
        String sql = "UPDATE materias SET nombre_materia = ? WHERE id = ?";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM materias WHERE id = ?";
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
    public MateriaModel buscarPorId(int id) {
        String sql = "SELECT * FROM materias WHERE id = ?";
        MateriaModel materia = null;
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    materia = new MateriaModel();
                    materia.setId(rs.getInt("id"));
                    materia.setNombreMateria(rs.getString("nombre_materia"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materia;
    }

    @Override
    public List<MateriaModel> listarTodos() {
        List<MateriaModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM materias";
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MateriaModel materia = new MateriaModel();
                materia.setId(rs.getInt("id"));
                materia.setNombreMateria(rs.getString("nombre_materia"));
                lista.add(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
