package modulo1;

import java.util.Scanner;

public class BusquedasNumerosArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cuantos numeros deseas ingresar?");
        int cantidad = scanner.nextInt();


        int[] numeros = new int[cantidad];

        for(int i = 0; i< cantidad; i++){
            System.out.print("Ingresa el numero" + (i+1) + ":");
            numeros[i] = scanner.nextInt();
        }

        System.out.print("¿Que numero desea buscar?");
        int buscar = scanner.nextInt();
        
        int i = 0;

        boolean encontrado = false;

        while (i < cantidad && !encontrado) {
            if(numeros[i] == buscar){
                encontrado = true;
            }
            i++;
        }

        if(encontrado){
            System.out.println("Numero encontrado en la posicion " + (i - 1));
        }else{
            System.out.println("Numero no encontrado");
        }

        scanner.close();

    }
}
