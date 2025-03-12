package modulo2;

import javax.swing.JOptionPane;

public class ReservaDeBoletos {

    public static void main(String[] args) {
        String[] eventos = { "Fulbol - Final", "Basquet - Semifinal", "Tenis - Cuartos de final" };

        int[] boletosDisponibles = { 50, 30, 20 };

        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                    "Reserva de boletos\n" +
                            "1. Ver eventos disponibles\n" +
                            "2. Reserva de boletos\n" +
                            "3. Salir\n" +
                            "Seleccionar una opción:");
            switch (opcion) {
                case "1":
                    verEventos(eventos, boletosDisponibles);
                    break;
                case "2":
                    reservarBoletos(eventos, boletosDisponibles);
                    break;
                case "3":
                    continuar = false;
                    System.out.println("Gracias por usar el sistema de reservas.");
                default:
                    System.out.println("Opción no valida, por favor intenta de nuevo");
                    break;
            }
        }
    }

    private static void verEventos(String[] eventos, int[] boletosDisponibles) {
        StringBuilder listaEventos = new StringBuilder("Eventos disponibles:\n");
        for (int i = 0; i < eventos.length; i++) {
            listaEventos.append(i + 1).append(". ").append(eventos[i])
                    .append(" - Boletos disponibles: ").append(boletosDisponibles[i])
                    .append("\n");
        }
        System.out.println(listaEventos.toString());
    }

    private static void reservarBoletos(String[] eventos, int[] boletosDisponibles) {
        StringBuilder listaEventos = new StringBuilder("Selecciona un evento\n");
        for (int i = 0; i < eventos.length; i++) {
            listaEventos.append(i + 1).append(". ").append(eventos[i])
                    .append(" (Boletos disponibles: ").append(boletosDisponibles[i]).append(")\n");
        }

        String seleccion = JOptionPane.showInputDialog(listaEventos.toString());
        int eventoSeleccionado;


        try{
            eventoSeleccionado = Integer.parseInt(seleccion) -1;
            if(eventoSeleccionado < 0 || eventoSeleccionado >= eventos.length){
                JOptionPane.showMessageDialog(null,"Opción no valida, intentalo de nuevo");
                return;
            }
        }catch(NumberFormatException e){
            System.out.println("Por favor ingresar un número valido");
            return;
        }

        int disponibles = boletosDisponibles[eventoSeleccionado];

        if(disponibles > 0){
            String cantidadStr = JOptionPane.showInputDialog(
                "Has seleccionado: "+eventos[eventoSeleccionado]+
                "\nBoletos disponibles: "+ disponibles+
                "\n¿Cuantos boletos deseas reservar?"
            );
            try{
                int cantidad = Integer.parseInt(cantidadStr);
                if(cantidad <= disponibles){
                    boletosDisponibles[eventoSeleccionado] -= cantidad;

                    String mensaje = "Reserva exitosa. Has reservado " + cantidad +
                                     "  boleto(s) para" + eventos[eventoSeleccionado]+ ".";
                                     System.out.println(mensaje);
                }else{
                    System.out.println("No hay suficientes boletos disponibles. Intenta con una cantidad menor.");
                }
            }catch(NumberFormatException e){
                String error = "Por favor ingresar un número valido.";
                System.out.println(error);
            }
        }else{
            String error = "Lo sentimos, no hay boletos disponibles para este evento.";
            System.out.println(error);
        }
    }

}
