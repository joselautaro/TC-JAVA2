package modulo3.VehiculosEnAlquiler;

public class Motocicleta implements VehiculoAlquilable {
    private String marca;
    private boolean alquilado;

    public Motocicleta(String marca) {
        this.marca = marca;
        this.alquilado = false;
    }

    @Override
    public void alquilar(int edad) throws EdadInsuficienteException, ClienteNoValidoException {
        if (edad < 18) {
            throw new EdadInsuficienteException("El cliente no tiene la suficiente edad para alquilar");
        }
        if (alquilado) {
            throw new ClienteNoValidoException("El vehiculo ya ha sido alquilado");
        }
        alquilado = true;
        System.out.println("El vehiculo " + marca + " ya ha sido alquilado");
    }

    @Override
    public void devolver() {
        alquilado = false;
        System.out.println("La motocicleta " + marca + " ha sido alquilado");
    }

}
