package modulo1;

import java.util.Scanner;

public class ConversionKilometrosAMillas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la distancia en kilometros");
        double km = sc.nextDouble();

        double millas = km * 0.621371;

        System.out.println(millas);

        sc.close();
    }
}
