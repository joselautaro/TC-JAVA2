package modulo3.CuentasBancarias;

public interface CuentaBancaria{
    void depositar(double monto);
    void retirar(double monto) throws FondosInsuficientesException;
    double consultarSaldo();
    double calcularIntereses();
}