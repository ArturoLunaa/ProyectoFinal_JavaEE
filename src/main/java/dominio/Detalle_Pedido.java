
package dominio;

/**
 *
 * @author artur
 */
public class Detalle_Pedido {
    private int idDetallePedido;
    private int idPedido;
    private int idProducto;
    private int cantidad;

    public Detalle_Pedido(int idDetallePedido, int idPedido, int idProducto, int cantidad) {
        this.idDetallePedido = idDetallePedido;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Detalle_Pedido(int idPedido, int idProducto, int cantidad) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Detalle_Pedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalle_Pedido{");
        sb.append("idDetallePedido=").append(idDetallePedido);
        sb.append(", idPedido=").append(idPedido);
        sb.append(", idProducto=").append(idProducto);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }
    
    
}
