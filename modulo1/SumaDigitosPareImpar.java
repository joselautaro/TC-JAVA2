package modulo1;

import java.util.Scanner;

public class SumaDigitosPareImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero; 

        do{
            System.out.print("Ingrese un numero entero positivo:");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada invalida. Por favor ingresar un numero entero positivo.");
                scanner.next();
            }
            numero = scanner.nextInt();
            if(numero < 0){
                System.out.println("Numero invalido. Por favor ingrese un numero positivo");
            }
        }while(numero < 0);

        int suma = 0;
        int temp = numero;
        int numeroInvertido = 0;
        int contadorPares = 0; 
        int contadorImpares = 0;

        while (temp > 0) {
            int digito = temp % 10;
            suma += digito;
            numeroInvertido = (numeroInvertido * 10) + digito;

            if(digito % 2 == 0){
                contadorPares++;
            }else{
                contadorImpares++;
            }

            temp /= 10;
        }

        System.out.println("La suma de los digitos de " + numero + " es: " + suma);
        System.out.println("Cantidad de digitos pares " + contadorPares);
        System.out.println("Cantidad de digitos impares: " + contadorImpares);

        if(numero == numeroInvertido){
            System.out.println("El número " + numero + " es un palindromo");
        }else{
            System.out.println("El numero " + numero + " no es un palindromo");
        }

        scanner.close();
    }
}
