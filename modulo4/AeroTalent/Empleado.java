package modulo4.AeroTalent;

public class Empleado extends Persona{

    public Empleado(String nombre, String id){
        super(nombre, id);
    }

    @Override
    public void mostrarDetalles(){
        System.out.println("Empleado: " + nombre + ". ID: " + id);
    }
    
}
