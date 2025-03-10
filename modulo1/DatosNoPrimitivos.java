package modulo1;

public class DatosNoPrimitivos {
    public static void main(String[] args) {
        
        
        String nombre = "Juan";
        System.out.println(nombre);

        Integer edad = 25;
        System.out.println(edad);

        String[] colores = {"Rojo", "Verde", "Azul"};
        for(String color : colores){
            System.out.println(color);
        }

        Persona persona = new Persona("Ana", 30);
        System.out.println("Informacion de la persona:");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());


    }
}

class Persona{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }
}
