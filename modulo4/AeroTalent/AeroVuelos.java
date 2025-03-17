package modulo4.AeroTalent;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class AeroVuelos {

    private ArrayList<Vuelo> vuelos;

    private HashMap<String, Cliente> clientes;

    private HashMap<String, Reserva> reservas;

    public AeroVuelos() {
        vuelos = new ArrayList<>();
        clientes = new HashMap<>();
        reservas = new HashMap<>();
    }

    public void agregarVuelo() {
        String numeroVuelo = JOptionPane.showInputDialog("Ingresa el número de vuelo: ");
        String origen = JOptionPane.showInputDialog("Ingrese el origen del vuelo");
        String destino = JOptionPane.showInputDialog("Ingrese el destino del vuelo");

        System.out.println("El número de vuelo es: " + numeroVuelo + "\ncon origen desde " + origen
                + "\n con destino de: " + destino);

        Vuelo vuelo = new Vuelo(numeroVuelo, origen, destino);

        vuelos.add(vuelo);

        System.out.println("Vuelo agregado éxito");
    }

    public void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del cliente: ");

        String id = JOptionPane.showInputDialog("Ingresa el id del cliente: ");

        System.out.println("El cliente registrado es: " + nombre + "\n ID: " + id);

        Cliente cliente = new Cliente(nombre, id);

        clientes.put(id, cliente);

        System.out.println("Cliente agregado con éxito");
    }

    public void reservarVuelo() {

        try {
            String idCliente = JOptionPane.showInputDialog("Ingrese el id del cliente");

            Cliente cliente = buscarCliente(idCliente);

            String numeroVuelo = JOptionPane.showInputDialog("Ingrese el número de vuelo a reservar");

            Vuelo vuelo = buscarVuelo(numeroVuelo);

            if (vuelo.isDisponible()) {

                vuelo.reservar();

                Reserva reserva = new Reserva(cliente, vuelo);

                reservas.put(cliente.getNombre(), reserva);

                reserva.mostrarDetalles();

                System.out.println("Reserva realizada con éxito");
            } else {
                System.out.println("El vuelo no está disponible");
            }
        } catch (ClienteNoRegistradoException | VueloNoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void mostrarVuelosDisponible() {
        StringBuilder sb = new StringBuilder();

        for (Vuelo vuelo : vuelos) {
            if (vuelo.isDisponible()) {
                sb.append("Vuelo ").append(vuelo.getNumeroVuelo()).append(": ")
                        .append(vuelo.getOrigen()).append(" a ").append(vuelo.getDestino()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No hay vuelos disponibles");
    }

    public void mostrarReservar() {
        StringBuilder sb = new StringBuilder();

        for (Reserva reserva : reservas.values()) {
            sb.append("Cliente: ").append(reserva.getCliente().getNombre())
                    .append(" - Vuelo: ").append(reserva.getVuelo().getNumeroVuelo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No hay reservas realizadas");
    }

    public void cancelarReserva() {
        try {
            String idCliente = JOptionPane.showInputDialog("Ingrese el id del cliente");

            Cliente cliente = buscarCliente(idCliente);

            Reserva reserva = reservas.get(cliente.getNombre());

            if (reserva != null) {
                Vuelo vuelo = reserva.getVuelo();

                vuelo.setDisponible(true);

                reservas.remove(cliente.getNombre());

                System.out.println("Reserva cancelada con éxito");
            } else {
                System.out.println("No sé encontró una reserva para el cliente");
            }
        } catch (ClienteNoRegistradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void actualizarVuelo() {
        try {
            String numeroVuelo = JOptionPane.showInputDialog("Ingrese el número de vuelo a actualizar");

            Vuelo vuelo = buscarVuelo(numeroVuelo);

            String nuevoOrigen = JOptionPane.showInputDialog("Ingrese el nuevo origen del vuelo:");

            String nuevoDestino = JOptionPane.showInputDialog("Ingrese el nuevo destino del vuelo:");

            vuelo.setOrigen(nuevoOrigen);

            vuelo.setDestino(nuevoDestino);

            System.out.println("Detalles del vuelo actualizados con éxito");
        } catch (VueloNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente buscarCliente(String id) throws ClienteNoRegistradoException {
        Cliente cliente = clientes.get(id);

        if (cliente == null) {
            throw new ClienteNoRegistradoException("error: cliente no registrado");
        }
        return cliente;
    }

    private Vuelo buscarVuelo(String numeroVuelo) throws VueloNoEncontradoException {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getNumeroVuelo().equals(numeroVuelo)) {
                return vuelo;
            }
        }
        throw new VueloNoEncontradoException("Error: vuelo no encontrado");
    }

    public static void main(String[] args) {
        AeroVuelos aeroVuelos = new AeroVuelos();

        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    "Menú sistema de vuelos:\n" +
                            "1. Agregar vuelos (Empleado)\n" +
                            "2. Registrar cliente\n" +
                            "3. Reservar vuelo (clientes)\n" +
                            "4. Mostrar vuelos disponibles\n" +
                            "5. Mostrar reservas\n" +
                            "6. Cancelar reservas\n" +
                            "7. Actualizar vuelo (empleado)\n" +
                            "8. Salir\n" +
                            "Ingrese una opción:");

            switch (opcion) {
                case "1":
                    aeroVuelos.agregarVuelo();
                    break;
                case "2":
                    aeroVuelos.registrarCliente();
                    break;
                case "3":
                    aeroVuelos.reservarVuelo();
                    break;
                case "4":
                    aeroVuelos.mostrarVuelosDisponible();
                    break;
                case "5":
                    aeroVuelos.mostrarReservar();
                    break;
                case "6":
                    aeroVuelos.cancelarReserva();
                    break;
                case "7":
                    aeroVuelos.actualizarVuelo();
                    break;
                case "8":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
