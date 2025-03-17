package modulo4.Biblioteca;

public class LibroNoEncontradoException extends Exception{

    public LibroNoEncontradoException(String mensaje){
        super(mensaje);
    }
}