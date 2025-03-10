package modulo1;

import java.util.Scanner;

public class MultiplicacionDecimales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el primer numero decimal");
        double numero1 = sc.nextDouble();

        System.out.println("Ingrese el segundo numero decimal");
        double numero2 = sc.nextDouble();

        double resultado = numero1 * numero2;

        System.out.println(resultado);

        sc.close();
    }
}
