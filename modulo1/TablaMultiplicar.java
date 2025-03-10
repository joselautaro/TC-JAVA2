package modulo1;

import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero inicial del rango");
        int inicio = scanner.nextInt();


        System.out.print("Ingrese el numero final del rango");
        int fin = scanner.nextInt();

        if(inicio > fin){
            System.out.println("El número inicial debe ser menor o igual al numero final. Intentelo de nuevo");
        }else{
            for(int i = inicio; i <= fin; i++){
                System.out.println("\nTabla de multiplicar del " + i + ":");
                for(int j = 1; j <= 10; j++){
                    System.out.println(i + " x " + j + " = " + (i*j));
                }
            }
        }
        scanner.close();

    }
}
