/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.*;

import Config.DbCon;
import InterfazDAO.IntContenidoDAO;
import Models.ContenidoModel;

public class ContenidoDAO implements IntContenidoDAO {

    @Override
    public boolean insertar(ContenidoModel contenido) {
        String sql = "INSERT INTO contenidos (materia_id, titulo, publicador, fecha_publicacion, cuerpo_texto, imagen_url) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, contenido.getMateriaId());
            ps.setString(2, contenido.getTitulo());
            ps.setString(3, contenido.getPublicador());
            ps.setDate(4, new java.sql.Date(contenido.getFechaPublicacion().getTime()));
            ps.setString(5, contenido.getCuerpoTexto());
            ps.setString(6, contenido.getImagenUrl());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(ContenidoModel contenido) {
        String sql = "UPDATE contenidos SET titulo = ?, publicador = ?, fecha_publicacion = ?, cuerpo_texto = ?, imagen_url = ? WHERE id = ?";
    
        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, contenido.getTitulo());
            ps.setString(2, contenido.getPublicador());
            ps.setDate(3, new java.sql.Date(contenido.getFechaPublicacion().getTime()));
            ps.setString(4, contenido.getCuerpoTexto());
            ps.setString(5, contenido.getImagenUrl());
            ps.setInt(6, contenido.getId()); // Fundamental para saber a quién actualizar

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM contenidos WHERE id = ?";

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
    public ContenidoModel buscarPorId(int id) {
        String sql = "SELECT * FROM contenidos WHERE id = ?";
        ContenidoModel contenido = null;

        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    contenido = new ContenidoModel();
                    contenido.setId(rs.getInt("id"));
                    contenido.setMateriaId(rs.getInt("materia_id"));
                    contenido.setTitulo(rs.getString("titulo"));
                    contenido.setPublicador(rs.getString("publicador"));
                    contenido.setFechaPublicacion(rs.getDate("fecha_publicacion"));
                    contenido.setCuerpoTexto(rs.getString("cuerpo_texto"));
                    contenido.setImagenUrl(rs.getString("imagen_url"));
                    contenido.setPromedioEstrellas(rs.getDouble("promedio_estrellas"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar contenido por ID: " + e.getMessage());
            e.printStackTrace();
        }
        
        return contenido;
    }
    
    @Override
    public List<ContenidoModel> listarTodos() {
        List<ContenidoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM contenidos";

        try (Connection con = DbCon.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ContenidoModel c = new ContenidoModel();
                c.setId(rs.getInt("id"));
                c.setMateriaId(rs.getInt("materia_id"));
                c.setTitulo(rs.getString("titulo"));
                c.setPublicador(rs.getString("publicador"));
                c.setFechaPublicacion(rs.getDate("fecha_publicacion"));
                c.setCuerpoTexto(rs.getString("cuerpo_texto"));
                c.setImagenUrl(rs.getString("imagen_url"));
                c.setPromedioEstrellas(rs.getDouble("promedio_estrellas"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
