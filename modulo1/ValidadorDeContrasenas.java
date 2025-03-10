package modulo1;

import java.util.Scanner;

public class ValidadorDeContrasenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = "1234";

        int intentos = 3;

        boolean accesoPermitido = false;

        while (intentos > 0 && !accesoPermitido) {
            System.out.println("Ingrese la contreña: ");
            String input = scanner.nextLine();

            if(input.equals(password)){
                System.out.println("Acceso concedido");
                accesoPermitido = true;
            }else{
                intentos--;
                System.out.println("Contraseña incorrecta. Te quedan " + intentos + " intentos");
            }
        }
        if(!accesoPermitido){
            System.out.println("Acceso denegado. Se acabaron los intentos");
        }
        scanner.close();
    }
}
