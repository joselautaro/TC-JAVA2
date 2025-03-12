package modulo3.CalculandoAndo;

public abstract class Automovil implements Vehiculo{
    protected String marca;
    protected String modelo;
    protected int anios;
    protected double precio;

    public Automovil(String marca, String modelo, int anios, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anios = anios;
        this.precio = precio;
    }

    @Override
    public void mostrarDetalles(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anios);
        System.out.println("Precio: " + precio);
    }

    public abstract double calcularImpuesto();

    
}
