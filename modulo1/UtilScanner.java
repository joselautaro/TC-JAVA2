package modulo1;

import java.util.Scanner;

public class UtilScanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese la temperatura en grados celsius: ");
        double celsius = scan.nextDouble();

        double fahrenheit = (celsius * 9 /5) + 32;

        System.out.println(celsius + " grados celsius son " + fahrenheit + " grados fahrenheit");

        scan.close();
    }
}
