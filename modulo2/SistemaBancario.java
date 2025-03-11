package modulo2;

import javax.swing.JOptionPane;

public class SistemaBancario {
    public static void main(String[] args) {
        String numeroCuenta1 = JOptionPane.showInputDialog("Ingrese el número de la primera cuenta");
        String titular1 = JOptionPane.showInputDialog("Ingrese el nombre del titular de la primera cuenta");
        double saldo1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial primera cuenta"));

        CuentaBancaria cuenta1 = new CuentaBancaria(numeroCuenta1, titular1, saldo1);

        String numeroCuenta2 = JOptionPane.showInputDialog("Ingrese el número de la segunda cuenta");
        String titular2 = JOptionPane.showInputDialog("Ingrese el nombre de titular de la segunda cuenta");

        CuentaBancaria cuenta2 = new CuentaBancaria(numeroCuenta2, titular2);

        System.out.println("Detalles iniciales de las cuentas:");
        cuenta1.mostrarDetalles();
        cuenta2.mostrarDetalles();

        double deposito1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar en la primera cuenta"));
        cuenta1.depositar(deposito1);

        double retiro1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar en la primera cuenta"));
        cuenta1.retirar(retiro1);

        double deposito2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar en la segunda cuenta"));
        cuenta2.depositar(deposito2);

        double retiro2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese a retirar de la segunda cuenta"));
        cuenta2.retirar(retiro2);

        System.out.println("\nDetalles después de las operaciones");
        cuenta1.mostrarDetalles();
        cuenta2.mostrarDetalles();

        System.out.println("\nTotal de cuentas creadas: " + CuentaBancaria.getTotalCuentas());

    }
}

class CuentaBancaria{
    private String numeroCuenta;
    private String titular;
    private double saldo;

    private static int totalCuentas = 0;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        totalCuentas++;
    }

    public CuentaBancaria(String numeroCuenta, String titular){
        this(numeroCuenta, titular, 0.0);
    }

    public void depositar(double cantidad){
        if(cantidad > 0){
            saldo += cantidad;
            System.out.println("Depósito exitoso en la cuenta: " + numeroCuenta + ". Nuevo saldo: " + saldo);
        }else{
            System.out.println("El depósito debe ser una cantidad positiva");
        }
    }

    public void retirar(double cantidad){
        if(cantidad > 0 && cantidad <= saldo){
            saldo -= cantidad;
            System.out.println("Retiro exitoso en la cuenta " + numeroCuenta + ". Nuevo saldo: " + saldo);
        }else if(cantidad > saldo){
            System.out.println("Saldo insuficiente para realizar el retiro en la cuenta " + numeroCuenta + ".");
        }else{
            System.out.println("La cantidad a retirar debe ser positiva");
        }
    }

    public void mostrarDetalles(){
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }

    public static int getTotalCuentas(){
        return totalCuentas;
    }
}


