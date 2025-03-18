package modulo5.EmpreTalent;

public class Libro extends Producto {
    private String autor;

    public Libro(String nombre, double precio, int cantidad, String autor) {
        super(nombre, precio, cantidad, CategoriaProducto.LIBROS);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAutor: " + autor;
    }
}
