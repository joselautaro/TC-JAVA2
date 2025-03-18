package modulo5.EmpreTalent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

public class SistemaTienda {
    private List<Producto> inventario;

    public SistemaTienda(){
        inventario = new ArrayList<>();
    }

    private String solicitarInput(String mensaje){
        return JOptionPane.showInputDialog(mensaje);
    }

    private double solicitarDouble(String mensaje){
        while (true) {
            try{
                return Double.parseDouble(solicitarInput(mensaje));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }
        }
    }
    private int solicitarEntero(String mensaje){
        while (true) {
            try{
                return Integer.parseInt(solicitarInput(mensaje));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un número entero válido");
            }
        }
    }

    @OperacionSegura(descripcion = "Agregar un producto al inventario")
    public void agregarProducto(){
        String nombre = solicitarInput("Ingrese el nombre del producto");

        String[] categorias = {"ELECTRONICA", "ROPA", "LIBROS"};

        String categoriaSeleccionada = (String) JOptionPane.showInputDialog(null,
                "Seleccione la categoria del producto: ",
                "Categorias", JOptionPane.QUESTION_MESSAGE, null, categorias, categorias[0]);
                System.out.println("Producto a agregar: " + nombre + "\nCategoria: " + categoriaSeleccionada);

        CategoriaProducto categoria = CategoriaProducto.valueOf(categoriaSeleccionada);

        double precio = solicitarDouble("Ingrese el precio del producto: ");

        int cantidad = solicitarEntero("Ingrese la cantidad disponible");

        Producto nuevoProducto;

        switch (categoria) {
            case ELECTRONICA:
                int garantia = solicitarEntero("Ingrese los meses de garantia");
                nuevoProducto = new Electronica(nombre, precio, cantidad, garantia);
                break;
            case ROPA:
                String talla = solicitarInput("Ingrese la talla de la ropa: ");
                nuevoProducto = new Ropa(nombre, precio, cantidad, talla);
                break;
            case LIBROS:
                String autor = solicitarInput("Ingrese el autor del libro: ");
                nuevoProducto = new Libro(nombre, precio, cantidad, autor);
                break;
            default:
                throw new IllegalStateException("Categoria no válida: " + categoria);
        }
        inventario.add(nuevoProducto);
        System.out.println("Producto agregado satisfactoriamente: " + nuevoProducto);
    }

    @OperacionSegura(descripcion = "Mostrar inventario")
    public void mostrarInventario(){
        if(inventario.isEmpty()){
            System.out.println("No hay productos en el inventario");
        }else{
            StringBuilder sb = new StringBuilder();
            for(Producto p : inventario){
                sb.append(p.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    @OperacionSegura(descripcion = "Aplicar descuento a todos")
    public void aplicarDescuentoATodos(){
        double porcentaje = solicitarDouble("Ingrese el porcentaje de descuento: ");

        inventario.forEach(p -> {
            p.aplicarDescuento(porcentaje);
            System.out.println("Descuento aplicado al producto: " + p + " con un " + porcentaje + "% de descuento");
        });
    }

    public static void main(String[] args) {
        SistemaTienda sistema = new SistemaTienda();

        Map<Integer, Consumer<Void>> menuOpciones = new HashMap<>();

        menuOpciones.put(1, (v) -> sistema.agregarProducto());
        menuOpciones.put(2, (v) -> sistema.mostrarInventario());
        menuOpciones.put(3, (v) -> sistema.aplicarDescuentoATodos());

        boolean salir = false;

        while (!salir) {
            String opcion = sistema.solicitarInput(
                "1. Agregar producto\n"+
                "2. Mostrar inventario\n"+
                "3. Aplicar descuento a todos\n"+
                "4. Salir\n"+
                "Seleccione una opción: ");
                try{
                    int opcionInt = Integer.parseInt(opcion);
                    Consumer<Void> operacion = menuOpciones.get(opcionInt);
                    if(operacion != null){
                        operacion.accept(null);
                    }else if(opcionInt == 4){
                        salir = true;
                        System.out.println("Saliendo del sistema tienda...");
                    }else{
                        System.out.println("Opción no válida");
                    }
                }catch(NumberFormatException e){
                    System.out.println("Error, ingrese un número válido");
                }
        }
    }
}
