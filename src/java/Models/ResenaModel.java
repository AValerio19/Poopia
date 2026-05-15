package Models;

import java.util.Date;

public class ResenaModel {
    private int id;
    private int usuarioId;
    private int contenidoId;
    private int estrellas;
    private String comentario;
    private Date fechaResena;

    public ResenaModel() {
    }

    public ResenaModel(int id, int usuarioId, int contenidoId, int estrellas, String comentario, Date fechaResena) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.contenidoId = contenidoId;
        this.estrellas = estrellas;
        this.comentario = comentario;
        this.fechaResena = fechaResena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(int contenidoId) {
        this.contenidoId = contenidoId;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(Date fechaResena) {
        this.fechaResena = fechaResena;
    }
}
