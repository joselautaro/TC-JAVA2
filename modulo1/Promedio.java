package modulo1;

import java.util.Scanner;

public class Promedio {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el primer numero");
        double num1 = sc.nextDouble();

        System.out.println("Ingrese el segundo numero");
        double num2 = sc.nextDouble();

        System.out.println("Ingrese el tercero numero");
        double num3 = sc.nextDouble();

        double promedio = (num1+num2+num3) / 3;

        System.out.println(promedio);

        sc.close();
    }


}
