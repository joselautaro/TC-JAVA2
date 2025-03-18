package modulo4.Biblioteca;

import java.util.*;

import javax.swing.JOptionPane;

public class Biblioteca {
    private Map<String, Usuario> usuarios;

    private List<Libro> libros;

    private Map<String, String> prestamos;

    private Random random;

    public Biblioteca() {
        this.usuarios = new HashMap<>();
        this.libros = new ArrayList<>();
        this.prestamos = new HashMap<>();
        this.random = new Random();
    }

    public void agregarUsuario() {
        String nombre = solicitarInput("Ingrese el nombre del usuario");

        String tipo = solicitarInput("Ingrese el tipo de usuario:");

        String id;
        do {
            id = String.valueOf(100000 + random.nextInt(900000));
        } while (usuarios.containsKey(id));

        Usuario usuario = new Usuario(nombre, id, tipo);
        usuarios.put(id, usuario);
        System.out.println("Usuario agregado con éxito. ID asignado: " + id);
        System.out.println("Usuario agregado - Nombre: " + nombre + "\nID: " + id + "\nTipo: " + tipo);
    }

    public void agregarLibro() {
        String titulo = solicitarInput("Ingrese el título del libro:");
        String autor = solicitarInput("Ingrese el autor del libro:");

        Libro libro = new Libro(titulo, autor);
        libros.add(libro);
        System.out.println("Libro agregado con éxito - \nTitulo: " + titulo + "\nAutor: " + autor);
    }

    public void prestarLibro() {
        try {
            String idUsuario = solicitarInput("Ingrese el id del usuario que tomará el libro:");
            Usuario usuario = buscarUsuario(idUsuario);

            String tituloLibro = solicitarInput("Ingrese el título del libro a prestar:");

            Libro libro = buscarLibro(tituloLibro);

            if (libro.isDisponible()) {
                libro.prestar();
                prestamos.put(idUsuario, tituloLibro);
                System.out.println("El libro ha sido prestado con éxito: " + usuario.getNombre() + "\nEl libro es: "
                        + tituloLibro + "a " + usuario.getNombre() + "ID: " + idUsuario + ")");
            } else {
                System.out.println("Error, el libro ya está prestado.");
            }
        } catch (UsuarioNoRegistradoException | LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void devolverLibro() {
        try {
            String tituloLibro = solicitarInput("Ingrese el titulo del libro a devolver");

            Libro libro = buscarLibro(tituloLibro);

            if (prestamos.containsKey(tituloLibro)) {
                String idUsuario = prestamos.remove(tituloLibro);
                libro.devolver();
                System.out.println("Libro devuelto con éxito: " + tituloLibro + " por Usuario: (ID: " + idUsuario + ")");
            } else {
                System.out.println("Error, este libro no estaba prestado");
            }
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private Usuario buscarUsuario(String id) throws UsuarioNoRegistradoException {
        Usuario usuario = usuarios.get(id);

        if (usuario == null) {
            throw new UsuarioNoRegistradoException("Error usuario no registrado");
        }
        return usuario;
    }

    private Libro buscarLibro(String titulo) throws LibroNoEncontradoException {
        return libros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new LibroNoEncontradoException("Error: libro no encontrado"));
    }

    private String solicitarInput(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        return input;
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "Menu de la biblioteca\n" +
                            "1. Agregar usuario\n" +
                            "2. Agregar libro\n" +
                            "3. Prestar libro\n" +
                            "4. Devolver libro\n" +
                            "5. Salir\n" +
                            "Ingrese la opción:");
            switch (opcion) {
                case "1":
                    biblioteca.agregarUsuario();
                    break;
                case "2":
                    biblioteca.agregarLibro();
                    break;
                case "3":
                    biblioteca.prestarLibro();
                    break;
                case "4":
                    biblioteca.devolverLibro();
                    break;
                case "5":
                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, intente nuevamente");
            }
        }
    }
}
