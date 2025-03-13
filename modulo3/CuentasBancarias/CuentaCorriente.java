package modulo3.CuentasBancarias;

public class CuentaCorriente extends Cuenta{
    private double sobreGiroMaximo;

    public CuentaCorriente(String titular, double saldo, double sobreGiroMaximo) {
        super(titular, saldo);
        this.sobreGiroMaximo = sobreGiroMaximo;
    }

    @Override
    public double calcularIntereses(){
        return 0;
    }

    @Override
    public void retirar(double monto) throws FondosInsuficientesException{
        if(saldo + sobreGiroMaximo < monto){
            throw new FondosInsuficientesException("Fondos insuficientes y limite de sobre excedido");
        }
        saldo -= monto;
    }

   

    
}
