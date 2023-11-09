public class Producto {

    // Enum para los tipos de producto
    public enum TipoProducto {
        PAPELERIA, SUPERMERCADO, DROGUERIA
    }

    private String nombre;
    private TipoProducto tipo; // Cambiado de int a TipoProducto
    private int cantidadActual, cantidadMin, undVendidas;
    private double precioBase;

    public Producto(String nombre, TipoProducto tipo, int cantidadActual, int cantidadMin, double precioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadActual = cantidadActual;
        this.cantidadMin = cantidadMin;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public int getCantidadActual() { return cantidadActual; }

    void venta(int cantidadvendida) {

        if (this.cantidadActual - cantidadvendida >= 0){
            this.cantidadActual = cantidadvendida;
            undVendidas += 1;
        } else {
            System.out.println("Cantidad de venta supera al stock");
        }

    }

    void reabastecimiento(int cantidadreabastecida){

        if (cantidadActual <= cantidadMin){
            this.cantidadActual += cantidadreabastecida;
        } else {
            System.out.println("Aun no se llega a la cantidad de reabastecimiento");
        }

    }

    public int getCantidadMin() {
        return cantidadMin;
    }

    void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public int getUndVendidas() { return undVendidas; }


    public double getPrecioBase() {
        return precioBase;
    }

    void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double precioFinal() {
        switch (this.tipo) {
            case PAPELERIA:
                return precioBase * 1.16;
            case SUPERMERCADO:
                return precioBase * 1.04;
            case DROGUERIA:
                return precioBase * 1.12;
            default:
                return -1;
        }
    }

    @Override

    public String toString(){
        return nombre + "\n    Tipo: " + tipo + "\n    Cantidad Actual: " + cantidadActual + "\n    Cantidad para reabastecer: " + cantidadMin + "\n    Precio base: " + precioBase + "\n    Precio final: " + precioFinal();
    }

}