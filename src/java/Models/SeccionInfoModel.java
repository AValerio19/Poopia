package Models;

public class SeccionInfoModel {
    private int id;
    private int contenidoId;
    private String subtitulo;
    private String cuerpoTexto;
    private int orden;

    public SeccionInfoModel() {}

    public SeccionInfoModel(int id, int contenidoId, String subtitulo, String cuerpoTexto, int orden) {
        this.id = id;
        this.contenidoId = contenidoId;
        this.subtitulo = subtitulo;
        this.cuerpoTexto = cuerpoTexto;
        this.orden = orden;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getContenidoId() { return contenidoId; }
    public void setContenidoId(int contenidoId) { this.contenidoId = contenidoId; }

    public String getSubtitulo() { return subtitulo; }
    public void setSubtitulo(String subtitulo) { this.subtitulo = subtitulo; }

    public String getCuerpoTexto() { return cuerpoTexto; }
    public void setCuerpoTexto(String cuerpoTexto) { this.cuerpoTexto = cuerpoTexto; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }
}
