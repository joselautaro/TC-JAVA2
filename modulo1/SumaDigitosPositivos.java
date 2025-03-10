package modulo1;

import java.util.Scanner;

public class SumaDigitosPositivos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Ingrese un numero entero positivo");
        int numero = scanner.nextInt();

        if(numero < 0){
            System.out.println("Debe ingresar un numero positivo");
        }else{
            int suma = 0;

            while(numero > 0){
                int digito = numero % 10;

                suma += digito;

                numero /= 10;
            }
            System.out.println("La suma de los digitos es: " + suma);
        }

        scanner.close();

    }
}
