package modulo3.VehiculosEnAlquiler;

public class Auto implements VehiculoAlquilable {
    private String marca;
    private boolean alquilado;

    public Auto(String marca) {
        this.marca = marca;
        this.alquilado = false;
    }

    @Override
    public void alquilar(int edad) throws EdadInsuficienteException, ClienteNoValidoException {
        if (edad < 21) {
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
        System.out.println("El vehiculo " + marca + " ha sido alquilado");
    }
}
