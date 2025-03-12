package modulo2;

import javax.swing.JOptionPane;

public class SistemaInventarioProductos {
    public static void main(String[] args) {
        int cantidadProductos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto productos desea agregar?"));

        Producto[] productos = new Producto[cantidadProductos];

        for(int i = 0; i < cantidadProductos; i++){
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i + 1 ) + ":");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto " + (i + i + ":")));

            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad en inventario del producto " + (i + 1) + ":"));

            productos[i] = new Producto(nombre, precio, cantidad);
        }

        System.out.println("Detalles del inventario:");
        for(Producto producto : productos){
            producto.mostrarDetalle();
            System.out.println("---------------------");
        }

        System.out.println("Inventario total de todos los productos: " + Producto.getInventarioTotal() + " unidades.");
    }
}

class Producto{
    private String nombre;
    private double precio;
    private int cantidad;

    private static int inventarioTotal = 0;

    public Producto(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        inventarioTotal += cantidad;
    }

    public void mostrarDetalle(){
        System.out.println("Nombre del producto " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad en inventario " + cantidad);
    }
    public static int getInventarioTotal() {
        return inventarioTotal;
    }
}

