package modulo2;

import javax.swing.JOptionPane;

public class RegistroYCalificaciones {
    public static void main(String[] args) {
        int numEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estudiantes"));

        Estudiante[] estudiantes = new Estudiante[numEstudiantes];

        for(int i = 0; i < numEstudiantes; i++){
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1) + ":");
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante " + (i + 1) + ":"));

            int numCalificiones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las calificaciones que tiene el estudiante " + nombre + ":"));

            double[] calificaciones = new double[numCalificiones];

            for(int j = 0; j < numCalificiones; j++){
                calificaciones[j] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la calificación " + (j + 1) + " para " + nombre + ":"));
            }

            estudiantes[i] = new Estudiante(nombre, id, calificaciones);
        }

        System.out.println("Detalles de los estudiantes:");
        for(Estudiante estudiante : estudiantes){
            estudiante.mostrarDetalles();
            System.out.println("-------------------------");
        }
        System.out.println("Total de estudiantes registrados: " + Estudiante.getTotalEstudiantes());
    }
}

class Estudiante{
    private String nombre;
    private int id;
    private double[] calificaciones;

    private static int totalEstudiantes = 0;

    public Estudiante(String nombre, int id, double[] calificaciones){
        this.nombre = nombre;
        this.id = id;
        this.calificaciones = calificaciones;
        totalEstudiantes++;
    }

    public double calcularPromedio(){
        double suma = 0;
        for(double calificacion : calificaciones){
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    public void mostrarDetalles(){
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Calificaciones: ");
        for(double calificacion : calificaciones){
            System.out.println("- " + calificacion);
        }
        System.out.printf("Promedio: %.2f%n", calcularPromedio());
    }
    public static int getTotalEstudiantes() {
        return totalEstudiantes;
    }
}
