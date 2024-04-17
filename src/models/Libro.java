package models;

public class Libro {
    private String nombreLibro;
    private String editorial;
    private String nombreAutor;

    public Libro(String nombreLibro, String editorial, String nombreAutor) {
        this.nombreLibro = nombreLibro;
        this.editorial = editorial;
        this.nombreAutor = nombreAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getEditorial() {
        return editorial;
    }
}
