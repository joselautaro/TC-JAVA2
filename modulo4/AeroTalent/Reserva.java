package modulo4.AeroTalent;

public class Reserva {
    private Cliente cliente;

    private Vuelo vuelo;

    public Reserva(Cliente cliente, Vuelo vuelo){
        this.cliente = cliente;
        this.vuelo = vuelo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Vuelo getVuelo(){
        return vuelo;
    }

    public void mostrarDetalles(){
        System.out.println("Reserva: Cliente" + cliente.getNombre() + " - " + vuelo.getNumeroVuelo());
    }
}
