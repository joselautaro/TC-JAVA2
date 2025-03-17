package modulo4.Biblioteca;

public class Libro {
    private String titulo;

    private String autor;

    private boolean disponible;

    

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public void mostrarDetalles() {
        System.out.println("Libro: " + titulo + " - Autor: " + autor + " - Disponible: " + (disponible ? "Si" : "No"));
    }
}
