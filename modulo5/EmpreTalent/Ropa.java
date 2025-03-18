package modulo5.EmpreTalent;

public class Ropa extends Producto{
    private String talla;

    public Ropa(String nombre, double precio, int cantidad,  String talla) {
        super(nombre, precio, cantidad, CategoriaProducto.ROPA);
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public String toString(){
        return super.toString() + "\nTalla: " + talla;
    }
}
