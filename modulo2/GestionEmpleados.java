package modulo2;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestionEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Gestión de empleados\n" +
                            "1. Registrar empleados\n" +
                            "2. Buscar empleados\n" +
                            "3. Generar reporte\n" +
                            "Seleccionar una opción:");
            switch (opcion) {
                case "1":
                    registrarEmpleados(empleados);
                    break;
                case "2":
                    buscarEmpleados(empleados);
                    break;
                case "3":
                    generarReporte(empleados);
                    break;
                case "4":
                    continuar = false;
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Opción no valida, por favor intenta de nuevo");
                    break;
            }
        }

    }

    private static void registrarEmpleados(ArrayList<Empleado> empleados) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        String posicion = JOptionPane.showInputDialog("Ingrese la posición del empleado");

        String fechaContratacionStr = JOptionPane
                .showInputDialog("Ingrese la fecha de contratación (formato: dd-MM-yyyy)");

        LocalDate fechaContratacion;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            fechaContratacion = LocalDate.parse(fechaContratacionStr, formatter);
        } catch (Exception e) {
            System.out.println("Fecha invalida, se usará la fecha actual.");
            fechaContratacion = LocalDate.now();
        }

        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:"));
        empleados.add(new Empleado(nombre, posicion, fechaContratacion, salario));
        System.out.println("Empleado registrado exitosamente" + nombre);
    }

    private static void buscarEmpleados(ArrayList<Empleado> empleados) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado a buscar:");

        StringBuilder resultado = new StringBuilder("Resultado de busqueda:\n");

        boolean encontrado = false;

        for (Empleado empleado : empleados) {
            if (empleado.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.append(empleado).append("\n");
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println(resultado.toString());
        } else {
            System.out.println("No se encontraron empleados con ese nombre");
        }
    }

    private static void generarReporte(ArrayList<Empleado> empleados) {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }
        StringBuilder reporte = new StringBuilder("Reporte de empleado:\n");

        double[] salario = new double[empleados.size()];

        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            reporte.append(empleado).append("\n");
            salario[i] = empleado.getSalario();
        }

        double promedioSalario = Arrays.stream(salario).average().orElse(0);

        reporte.append("\nSalario promedio: ").append(String.format("%.2f", promedioSalario));

        System.out.println(reporte.toString());
    }
}

class Empleado {

    private String nombre;

    private String posicion;

    private LocalDate fechaContratacion;

    private double salario;

    public Empleado(String nombre, String posicion, LocalDate fechaContratacion, double salario) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Nombre: " + nombre +
                "\nPosición: " + posicion +
                "\nFecha de contratacion: " + fechaContratacion.format(formatter) +
                "\nSalario: " + String.format("%.2f", salario);
    }

}
