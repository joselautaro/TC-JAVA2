package modulo4.AeroTalent;

public class Cliente extends Persona{
    public Cliente(String nombre, String id){
        super(nombre, id);
    }

    @Override
    public void mostrarDetalles(){
        System.out.println("Cliente: " + nombre + ". ID: " + id);
    }
}