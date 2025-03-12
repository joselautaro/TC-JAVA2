package modulo2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestionTallerMecanico {
    public static void main(String[] args) {

        ArrayList<Cita> citas = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Taller Mecánico - Gestión de Citas\n" +
                            "1. Registrar nueva cita\n" +
                            "2. Mostrar todas las citas\n" +
                            "3. Buscar una cita por cliente\n" +
                            "4. Salir\n" +
                            "Seleccione una opción:");

            switch (opcion) {
                case "1":
                    registrarCita(citas);
                    break;
                case "2":
                    mostrarCitas(citas);
                    break;
                case "3":
                    buscarCita(citas);
                    break;
                case "4":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Adiós!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida. Inténtalo de nuevo.");
                    break;
            }
        }

    }

    private static void registrarCita(ArrayList<Cita> citas) {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
        String descripcionServicio = JOptionPane.showInputDialog("Ingrese la descripción del servicio");
        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la cita (dd/mm/aaaa)");

        Cita nuevaCita = new Cita(nombreCliente, descripcionServicio, fecha);
        citas.add(nuevaCita);
        JOptionPane.showMessageDialog(null, "Cita registrada exitosamente.");
    }

    private static void mostrarCitas(ArrayList<Cita> citas) {
        if (citas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay citas registradas.");
        } else {
            StringBuilder listaCitas = new StringBuilder("Citas registradas:\n");
            for (int i = 0; i < citas.size(); i++) {
                listaCitas.append((i + 1)).append(". ").append(citas.get(i).detallesCita()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaCitas.toString());
        }
    }

    private static void buscarCita(ArrayList<Cita> citas) {
        String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del cliente a buscar:");
        boolean encontrado = false;

        for (Cita cita : citas) {
            if (cita.getNombreCliente().equalsIgnoreCase(nombreBusqueda)) {
                JOptionPane.showMessageDialog(null, "Cita encontrada:\n" + cita.detallesCita());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna cita para el cliente: " + nombreBusqueda);
        }
    }
}

class Cita {

    private String nombreCliente;
    private String descripcionServicio;
    private String fecha;

    public Cita(String nombreCliente, String descripcionServicio, String fecha){
        this.nombreCliente = nombreCliente;
        this.descripcionServicio = descripcionServicio;
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    public String detallesCita(){
        return "Cliente: " + nombreCliente + ". \nServicio: " + descripcionServicio + ". \nFecha: " + fecha;
    }

}