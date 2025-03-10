package modulo1;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un palabra para verificar si es un palindromo:");
        String palabra = scanner.nextLine();

        palabra = palabra.toLowerCase();

        boolean esPalindromo = true;

        for(int i = 0; i< palabra.length() / 2; i++){
            if(palabra.charAt(i) != palabra.charAt(palabra.length() -1 -i)){
                esPalindromo = false;
                break;
            }
        }
        if(esPalindromo){
            System.out.println("La palabra \"" + palabra + "\" es un palindromo");
        }else{
            System.out.println("La palabra \"" + palabra + "\" no es un palindromo");
        }
        scanner.close();
    }
}
