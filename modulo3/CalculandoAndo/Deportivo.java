package modulo3.CalculandoAndo;

public class Deportivo extends Automovil {
    private int potencia;

    public Deportivo(String marca, String modelo, int anios, double precio, int potencia) {
        super(marca, modelo, anios, precio);
        this.potencia = potencia;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Potencia: " + potencia + " HP");
    }

    @Override
    public double calcularImpuesto() {
        return precio * 0.10 + (potencia * 2);
    }

}
