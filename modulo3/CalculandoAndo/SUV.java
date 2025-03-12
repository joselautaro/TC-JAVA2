package modulo3.CalculandoAndo;

public class SUV extends Automovil{
    private boolean traccionCuatroRuedas;

    public SUV(String marca, String modelo, int anios, double precio, boolean traccionCuatroRuedas) {
        super(marca, modelo, anios, precio);
        this.traccionCuatroRuedas = traccionCuatroRuedas;
    }

    @Override
    public void mostrarDetalles(){
        super.mostrarDetalles();
        System.out.println("Tracción 4x4: " + (traccionCuatroRuedas ? "Si" : "No"));
    }

    @Override
    public double calcularImpuesto(){
        return precio *0.08 + (traccionCuatroRuedas ? 500 : 0);
    }
    
}
