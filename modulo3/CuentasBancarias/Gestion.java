package modulo3.CuentasBancarias;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Gestion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            String tipoCuenta = JOptionPane.showInputDialog("¿Que tipo de cuenta desea abrir? (ahorr/corriente)");
            System.out.println("El tipo de cuenta es: " + tipoCuenta);

            Cuenta cuenta;

            if(tipoCuenta.equalsIgnoreCase("ahorro")){
                String tiular = JOptionPane.showInputDialog("Ingrese el nombre del titular de la cuenta");

                System.out.println("El nombre ingresado es: " + tiular);

                double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial de la cuenta de ahorro"));

                System.out.println("El saldo inicial es: " + saldoInicial);

                double tasaInteres = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tasa de interés (%):"));

                System.out.println("Tasa de interes ingresada es: " + tasaInteres + "%");

                cuenta = new CuentaAhorro(tiular, saldoInicial, tasaInteres);
            }else if(tipoCuenta.equalsIgnoreCase("corriente")){
                String titular = JOptionPane.showInputDialog("Ingrese el nombre del titular de la cuenta");

                System.out.println("El nombre ingresado es: " + titular);

                double saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial de la cuenta corriente"));

                System.out.println("El saldo inicial es: " + saldoInicial);

                double sobreGiroMaximo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el limite de sobre giro"));
                System.out.println("Limite de sobre giro establecido: " + sobreGiroMaximo);
                cuenta = new CuentaCorriente(titular, saldoInicial, sobreGiroMaximo);
            }else{
                throw new Exception("Tipo de cuenta no valido");
            }

            double montoDeposito = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto desea depositar?"));
            cuenta.depositar(montoDeposito);
            String mensajeDeposito = "Deposito realizado. Saldo actual: " + cuenta.consultarSaldo();
            System.out.println(mensajeDeposito);

            double montoRetiro = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto desea retirar?"));
            try{
                cuenta.retirar(montoRetiro);
                String mensajeRetiro = "Retiro realizado. Saldo actual: " + cuenta.consultarSaldo();
                System.out.println(mensajeRetiro);
            }catch(FondosInsuficientesException e){
                String errorRetiro = "Error: " + e.getMessage();
                System.out.println(errorRetiro);
            }
            if (cuenta instanceof CuentaAhorro) {
                double intereses = cuenta.calcularIntereses();
                String mensajeIntereses = "Intereses generados: $" + intereses;
                System.out.println(mensajeIntereses);
            }
        }catch(Exception e){
            String errorGeneral = "Se ha producido un error: " + e.getMessage();
            System.out.println(errorGeneral);
        }finally{
            scanner.close();
        }
    }
}
