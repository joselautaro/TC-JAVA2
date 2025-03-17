package modulo4.Biblioteca;

import java.util.*;

import javax.swing.JOptionPane;

public class Biblioteca {
    private Map<String, Usuario> usuarios;

    private List<Libro> libros;

    private Map<String, String> prestamos;

    private Random random;

    public Biblioteca(){
        this.usuarios = new HashMap<>();
        this.libros = new ArrayList<>();
        this.prestamos = new HashMap<>();
        this.random = new Random();
    }

    public void agregarUsuario(){
        String nombre = solicitarInput("Ingrese el nombre del usuario");

        String tipo = solicitarInput("Ingrese el tipo de usuario:");

        String id;
        do{
            id = String.valueOf(100000 + random.nextInt(900000));
        }while(usuarios.containsKey(id));

        Usuario usuario = new Usuario(nombre, id, tipo);
        usuarios.put(id, usuario);
        System.out.println("Usuario agregado con éxito. ID asignado: " + id);
        System.out.println("Usuario agregado - Nombre: " + nombre + "\nID: " + id + "\nTipo: " + tipo);
    }

    public void agregarLibro(){
        String titulo = solicitarInput("Ingrese el título del libro:");
        String autor = solicitarInput("Ingrese el autor del libro:");

        Libro libro = new Libro(titulo, autor);
        libros.add(libro);
        System.out.println("Libro agregado con éxito - \nTitulo: " + titulo + "\nAutor: " + autor);
    }

    public void prestarLibro(){
        try{
            String idUsuario = solicitarInput("Ingrese el id del usuario que tomará el libro:");
            Usuario usuario = buscarUsuario(idUsuario);

            String tituloLibro = solicitarInput("Ingrese el título del libro a prestar:");

            Libro libro = buscarLibro(tituloLibro);

            if(libro.isDisponible()){
                libro.prestar();
                prestamos.put(idUsuario, tituloLibro);
                System.out.println("El libro ha sido prestado con éxito: " + usuario.getNombre() + "\nEl libro es: " + tituloLibro + "a " + usuario.getNombre() + "ID: " + idUsuario + ")");
             }else{
                System.out.println("Error, el libro ya está prestado.");
             }
        }catch(UsuarioNoRegistradoException | LibroNoEncontradoException e){
            System.out.println(e.getMessage());
        }
    }

    private String solicitarInput(String mensaje){
        String input = JOptionPane.showInputDialog(mensaje);
        return input;
    }
}
