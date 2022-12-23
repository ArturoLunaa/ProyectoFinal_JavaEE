
package dominio;

public class Producto {
    private int idProducto;
    private String modelo;
    private String marca;
    private Double precio;
    private String imagen;
    private int idProovedor;

    public Producto(int idProducto, String modelo, String marca, Double precio, String imagen, int idProovedor) {
        this.idProducto = idProducto;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
        this.idProovedor = idProovedor;
    }

    public Producto(String modelo, String marca, Double precio, String imagen, int idProovedor) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.imagen = imagen;
        this.idProovedor = idProovedor;
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public int getIdProovedor() {
        return idProovedor;
    }

    public void setIdProovedor(int idProovedor) {
        this.idProovedor = idProovedor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("idProducto=").append(idProducto);
        sb.append(", modelo=").append(modelo);
        sb.append(", marca=").append(marca);
        sb.append(", precio=").append(precio);
        sb.append(", imagen=").append(imagen);
        sb.append(", idProovedor=").append(idProovedor);
        sb.append('}');
        return sb.toString();
    }
}
