package modulo3.VehiculosEnAlquiler;

public interface VehiculoAlquilable {
    void alquilar( int edad) throws EdadInsuficienteException, ClienteNoValidoException;
    void devolver();
}
