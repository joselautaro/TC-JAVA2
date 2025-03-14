// package modulo3.VehiculosEnAlquiler;

// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// import javax.swing.JOptionPane;

// public class SistemaAlquilar {
//     public static void main(String[] args) {
//         try {
           
//             Map<String, Function<String, VehiculoAlquilable>> vehiculosMap = new HashMap<>();
//             vehiculosMap.put("auto", Auto::new);
//             vehiculosMap.put("camion", Camion::new);
//             vehiculosMap.put("moto", Motocicleta::new);

//             String tipo = JOptionPane.showInputDialog("¿Qué tipo de vehículo desea alquilar? (auto/camion/moto)")
//                     .toLowerCase();
//             Function<String, VehiculoAlquilable> constructor = vehiculosMap.get(tipo);

            
//             if (constructor == null) {
//                 throw new Exception("Tipo de vehículo no válido.");
//             }

          
//             String marca = JOptionPane.showInputDialog("Ingrese la marca del " + tipo + ": ");
//             VehiculoAlquilable vehiculo = constructor.apply(marca);

      
//             int edad = obtenerEdadCliente();

         
//             alquilarVehiculo(vehiculo, edad);

            
//             int diasAlquiler = obtenerDiasAlquiler();

       
//             iniciarContadorDevolucion(diasAlquiler, vehiculo);
//         } catch (Exception e) {
//             manejarError(e);
//         }
//     }


//     private static int obtenerEdadCliente() throws NumberFormatException{
//         return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente:"));
//     }

//     private static int obtenerDiasAlquiler() throws NumberFormatException{
//         return Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos dias desea alquilar el vehiculo?"));
//     }

//     private static void alquilarVehiculo(VehiculoAlquilable vehiculo, int edad){
//         try{
//             vehiculo.alquilar(edad);
//             System.out.println("Vehiculo alquilado con éxito");
//         }catch(EdadInsuficienteException | ClienteNoValidoException e){
//             manejarError(e);
//         }finally{
//             System.out.println("El proceso de alquiler ha finalizado");
//         }
//     }

//     private static void iniciarContadorDevolucion(int diasInicial, VehiculoAlquilable vehiculo){
//         new Thread(() -> {
//             try{
//                 int dias = diasInicial;
//                 while(true){
//                     for(int i = dias; i > 0; i--){
//                         System.out.println("Tiempo restante para devolver: " + i + " dias");
//                         Thread.sleep(1000);
//                     }
//                     JOptionPane.showMessageDialog(null, "¡Debe devolver el vehiculo ahora!");
//                     if(confirmarDevolucion()){
//                         vehiculo.devolver();
//                         System.out.println("El vehiculo ha sido devuelvo");
//                         break;
//                     }else{
//                         System.out.println("El vehiculo no ha sido devuelto, el usuario desea extender el alquiler");
//                         dias = obtenerDiasAlquiler();
//                     }
//                 }
//             }catch(InterruptedException e){
//                 manejarError(e);
//             }
//         }).start();
//     }

//     private static boolean confirmarDevolucion(){
//         return JOptionPane.showConfirmDialog(null, "¿Desea devolver el vehiculo ahora?") == JOptionPane.YES_OPTION;
//     }

//     private static void manejarError(Exception e){
//         String mensajeError = "Error: " + e.getMessage();
//         JOptionPane.showInputDialog(null, mensajeError);
//         System.out.println(mensajeError);
//     }
// }

package modulo3.VehiculosEnAlquiler;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SistemaAlquiler {
    public static void main(String[] args) {
        try {
            Map<String, Function<String, VehiculoAlquilable>> vehiculosMap = new HashMap<>();
            vehiculosMap.put("auto", Auto::new);
            vehiculosMap.put("camion", Camion::new);
            vehiculosMap.put("moto", Motocicleta::new);

            String tipo = JOptionPane.showInputDialog("¿Qué tipo de vehículo desea alquilar? (auto/camion/moto)").toLowerCase();
            Function<String, VehiculoAlquilable> constructor = vehiculosMap.get(tipo);

            if (constructor == null) {
                throw new Exception("Tipo de vehículo no válido.");
            }

            String marca = JOptionPane.showInputDialog("Ingrese la marca del " + tipo + ": ");
            VehiculoAlquilable vehiculo = constructor.apply(marca);
            
            int edad = obtenerEdadCliente();
            alquilarVehiculo(vehiculo, edad);
            
            int diasAlquiler = obtenerDiasAlquiler();
            iniciarContadorDevolucion(diasAlquiler, vehiculo);
        } catch (Exception e) {
            manejarError(e);
        }
    }

    private static int obtenerEdadCliente() throws NumberFormatException {
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente: "));
    }

    private static int obtenerDiasAlquiler() throws NumberFormatException {
        return Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos días desea alquilar el vehículo?"));
    }

    private static void alquilarVehiculo(VehiculoAlquilable vehiculo, int edad) {
        try {
            vehiculo.alquilar(edad);
            System.out.println("Vehículo alquilado con éxito");
        } catch (EdadInsuficienteException | ClienteNoValidoException e) {
            manejarError(e);
        } finally {
            System.out.println("El proceso de alquiler ha finalizado");
        }
    }

    private static void iniciarContadorDevolucion(int diasInicial, VehiculoAlquilable vehiculo) {
        new Thread(() -> {
            try {
                int dias = diasInicial;
                while (true) {
                    for (int i = dias; i > 0; i--) {
                        System.out.println("Tiempo restante para devolver el vehículo: " + i + " días");
                        Thread.sleep(1000);
                    }
                    JOptionPane.showMessageDialog(null, "¡Debe devolver el vehículo ahora!");
                    
                    if (confirmarDevolucion()) {
                        vehiculo.devolver();
                        System.out.println("El vehículo ha sido devuelto");
                        break;
                    } else {
                        System.out.println("El vehículo no ha sido devuelto, el usuario desea extender el alquiler.");
                        dias = obtenerDiasAlquiler();
                    }
                }
            } catch (InterruptedException e) {
                manejarError(e);
            }
        }).start();
    }

    private static boolean confirmarDevolucion() {
        return JOptionPane.showConfirmDialog(null, "¿Desea devolver el vehículo?") == JOptionPane.YES_OPTION;
    }

    private static void manejarError(Exception e) {
        String mensajeError = "Error: " + e.getMessage();
        JOptionPane.showMessageDialog(null, mensajeError);
        System.out.println(mensajeError);
    }
}

