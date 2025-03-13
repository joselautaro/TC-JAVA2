package modulo3.VehiculosEnAlquiler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JOptionPane;

public class SistemaAlquilar {
    public static void main(String[] args) {
        try{


            Map<String, Function<String, VehiculoAlquilable>> vehiculosMap = new HashMap<>();
            vehiculosMap.put("auto", Auto::new);
            vehiculosMap.put("camion", Camion::new);
            vehiculosMap.put("moto", Motocicleta::new);

            String tipo = JOptionPane.showInputDialog("¿Que tipo de vehiculo desea alquilar? (auto/camion/moto)").toLowerCase();
            Function<String, VehiculoAlquilable> constructor = vehiculosMap.get(tipo);

            if(constructor == null){
                throw new Exception("Tipo de vehiculo no válido");
            }

            String marca = JOptionPane.showInputDialog("Ingrese la marca del " + tipo + ":");
            VehiculoAlquilable vehiculo = constructor.apply(marca);

            int edad = obtenerEdadCliente();

            alquilarVehiculo(vehiculo, edad);

            int diasAlquiler = obtenerDiasAlquiler();

            iniciarContadorDevolucion(diasAlquiler, vehiculo);
        }catch(Exception e){
            manejarError(e);
        }
    }

    private static int obtenerEdadCliente() throws NumberFormatException{
        return Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente:"));
    }

    private static int obtenerDiasAlquiler() throws NumberFormatException{
        return Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos dias desea alquilar el vehiculo?"));
    }

    private static void alquilarVehiculo(VehiculoAlquilable vehiculo, int edad){
        try{
            vehiculo.alquilar(edad);
            System.out.println("Vehiculo alquilado con éxito");
        }catch(EdadInsuficienteException | ClienteNoValidoException e){
            manejarError(e);
        }finally{
            System.out.println("El proceso de alquiler ha finalizado");
        }
    }
}
