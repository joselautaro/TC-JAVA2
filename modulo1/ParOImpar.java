package modulo1;

import javax.swing.JOptionPane;

public class ParOImpar {
    public static void main(String[] args) {
        String numeroString = JOptionPane.showInputDialog("Escriba un numero:");

        int numero = Integer.parseInt(numeroString);

        if( numero % 2 == 0 ){
            JOptionPane.showMessageDialog(null, "El numero es par");
        }else{
            System.out.println("El numero es impar");
        }
    }
}
