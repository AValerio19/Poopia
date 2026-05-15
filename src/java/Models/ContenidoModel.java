/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.util.*;

public class ContenidoModel {
    private int id;
    private int materiaId;
    private String titulo;
    private String publicador;
    private Date fechaPublicacion;
    private String cuerpoTexto;
    private String imagenUrl;
    private double promedioEstrellas;
    
    public ContenidoModel() {}
    
    public ContenidoModel(int id, int materiaId, String titulo, String publicador, Date fechaPublicacion, String cuerpoTexto, String imagenUrl, double promedioEstrellas) {
        this.id = id;
        this.materiaId = materiaId;
        this.titulo = titulo;
        this.publicador = publicador;
        this.fechaPublicacion = fechaPublicacion;
        this.cuerpoTexto = cuerpoTexto;
        this.imagenUrl = imagenUrl;
        this.promedioEstrellas = promedioEstrellas;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMateriaId() { return materiaId; }
    public void setMateriaId(int materiaId) { this.materiaId = materiaId; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getPublicador() { return publicador; }
    public void setPublicador(String publicador) { this.publicador = publicador; }

    public Date getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(Date fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    
    public String getCuerpoTexto() { return cuerpoTexto; }
    public void setCuerpoTexto(String cuerpoTexto) { this.cuerpoTexto = cuerpoTexto; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
    
    public double getPromedioEstrellas() { return promedioEstrellas; }
    public void setPromedioEstrellas(Double promedioEstrellas) { this.promedioEstrellas = promedioEstrellas; }

    @Override
    public String toString() {
        return "Contenido{" + "id=" + id + ", titulo='" + titulo + '\'' + '}';
    }
}
