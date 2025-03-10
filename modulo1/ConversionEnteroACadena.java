package modulo1;

import java.util.Scanner;

public class ConversionEnteroACadena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero entero: ");
        int numero = sc.nextInt();

        String numeroComoCadena = Integer.toString(numero);

        System.out.println(numeroComoCadena);
        sc.close();
    }
}
