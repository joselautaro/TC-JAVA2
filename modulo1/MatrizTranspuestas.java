package modulo1;

import java.util.Scanner;

public class MatrizTranspuestas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de filas de la matriz: ");
        int filas = scanner.nextInt();

        System.out.print("Ingrese el numero de columnas de la matriz: ");
        int columnas = scanner.nextInt();

        int[][] matriz = new int[filas][columnas];


        System.out.println("Ingrese los elementos de la matriz");
        for(int i = 0; i< filas; i++){
            for(int j = 0; j< columnas; j++){
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        int[][] transpuesta = new int[columnas][filas];
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                transpuesta[j][i] = matriz[i][j];
            }
        }

        System.out.println("\nMatriz original: ");
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nMatriz transpuestas: ");
        for(int i = 0; i < columnas; i++){
            for(int j = 0; j < filas; j++){
                System.out.print(transpuesta[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();

    }
}
