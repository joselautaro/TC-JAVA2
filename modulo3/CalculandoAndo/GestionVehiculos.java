package modulo3.CalculandoAndo;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;


// Clase principal con el metodo main
public class GestionVehiculos {
    public static void main(String[] args) {
        List<Automovil> vehiculos = new ArrayList<>();
        
        try {
            String tipo = JOptionPane.showInputDialog("Ingrese el tipo de vehículo (Deportivo/SUV):");
            String marca = JOptionPane.showInputDialog("Ingrese la marca del auto:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del auto:");
            int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del auto:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del auto:"));
            
            if (anio < 1886 || precio <= 0) {
                throw new DatosInvalidosException("Año o precio no válidos");
            }
            
            Automovil vehiculo;
            if (tipo.equalsIgnoreCase("Deportivo")) {
                int potencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la potencia en HP del auto:"));
                vehiculo = new Deportivo(marca, modelo, anio, precio, potencia);
            } else if (tipo.equalsIgnoreCase("SUV")) {
                boolean traccionCuatroRuedas = JOptionPane.showInputDialog("¿Tiene tracción 4x4? (Sí/No):").equalsIgnoreCase("Sí");
                vehiculo = new SUV(marca, modelo, anio, precio, traccionCuatroRuedas);
            } else {
                throw new DatosInvalidosException("Tipo de vehículo no válido");
            }
            
            vehiculos.add(vehiculo);
            
            System.out.println("\nDetalles del vehículo:");
            vehiculo.mostrarDetalles();
            System.out.println("Impuesto estimado: " + vehiculo.calcularImpuesto() + " USD");
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida. Ingrese un número válido.");
        } catch (DatosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
