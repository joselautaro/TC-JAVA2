package modulo4.Biblioteca;

public class Usuario {
    private String nombre;
    private String id;
    private String tipo;

    public Usuario(String nombre, String id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
