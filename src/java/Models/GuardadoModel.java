package Models;

import java.util.Date;

public class GuardadoModel {
    private int usuarioId;
    private int contenidoId;
    private Date fechaGuardado;

    public GuardadoModel() {
    }

    public GuardadoModel(int usuarioId, int contenidoId, Date fechaGuardado) {
        this.usuarioId = usuarioId;
        this.contenidoId = contenidoId;
        this.fechaGuardado = fechaGuardado;
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

    public Date getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(Date fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }
}
