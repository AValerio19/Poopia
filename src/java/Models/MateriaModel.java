package Models;

public class MateriaModel {
    private int id;
    private String nombreMateria;

    public MateriaModel() {
    }

    public MateriaModel(int id, String nombreMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
}
