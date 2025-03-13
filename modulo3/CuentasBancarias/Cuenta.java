package modulo3.CuentasBancarias;

public abstract class Cuenta implements CuentaBancaria{
    protected String titular;
    protected double saldo;
    
    public Cuenta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    @Override
    public void depositar(double monto){
        saldo += monto;
    }
    @Override
    public double consultarSaldo(){
        return saldo;
    }
}
