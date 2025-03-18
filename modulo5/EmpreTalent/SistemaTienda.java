package modulo5.EmpreTalent;

import java.util.ArrayList;
import java.util.List;

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
}
