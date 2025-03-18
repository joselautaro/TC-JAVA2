package modulo5.EmpreTalent;

public class Producto implements Promocionable{
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;
    public Producto(String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public CategoriaProducto getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }
    @Override
    public void aplicarDescuento(double porcentaje){
        this.precio -= precio * (porcentaje/100);
    }

    @Override
    public String toString(){
        return "Producto: " + nombre + "\nPrecio: " + precio + "\nCantidad: " + cantidad + "\nCategoria: " + categoria;
    }
}
