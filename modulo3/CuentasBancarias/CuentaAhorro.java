package modulo3.CuentasBancarias;

public class CuentaAhorro extends Cuenta{
    private double tasaInteres;

    public CuentaAhorro(String titular, double saldo, double tasaInteres) {
        super(titular, saldo);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public double calcularIntereses(){
        return saldo * tasaInteres / 100;
    }

    @Override
    public void retirar(double monto) throws FondosInsuficientesException{
        if(saldo < monto){
            throw new FondosInsuficientesException("Fondos insuficientes para retirar");
        }
        saldo -= monto;
    }
    
}
