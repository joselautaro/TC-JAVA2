package modulo1;

import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el limite inferior del rango: ");
        int limiteInferior = scanner.nextInt();

        System.out.print("Ingrese el limite superior del rango");
        int limiteSuperior = scanner.nextInt();

        if(limiteInferior > limiteSuperior){
            System.out.println("El limite inferior debe ser menor o igual al limite superior");
        }else{
            int sumaPrimos = 0;
            for(int numero = limiteInferior; numero <= limiteSuperior; numero++){
                if(esPrimo(numero)){
                    sumaPrimos += numero;
                }
            }
            System.out.println("La suma de los numeros primos en el rango es: " + sumaPrimos);
        }
        scanner.close();

    }

    private static boolean esPrimo( int numero){
        if(numero <= 1){
            return false;
        }
        for(int divisor = 2; divisor <= Math.sqrt(numero); divisor++){
            if(numero % divisor == 0){
                return false;
            }
        }
        return true;
    }

}
