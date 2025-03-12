package modulo2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestionEmpleados {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        boolean continuar = false;

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
    private static void registrarEmpleados(ArrayList<Empleado> empleados){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        String posicion = JOptionPane.showInputDialog("Ingrese la posición del empleado");

        String fechaContratacionStr = JOptionPane.showInputDialog("Ingrese la fecha de contratación (formato: dd-MM-yyyy)");

        LocalDate fechaContratacion;

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            fechaContratacion = LocalDate.parse(fechaContratacionStr, formatter);
        }catch(Exception e){
            System.out.println("Fecha invalida, se usará la fecha actual.");
            fechaContratacion = LocalDate.now();
        }

        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:"));
        empleados.add(new Empleado(nombre, posicion, fechaContratacion, salario));
        System.out.println("Empleado registrado exitosamente" + nombre);
    }
}
