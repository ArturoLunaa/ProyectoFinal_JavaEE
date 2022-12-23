package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Detalle_Pedido;
import dominio.Pedido;
import dominio.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Detalle_PedidoDaoJDBC {
   private static final String SQL_SELECT = "SELECT id_detalle_pedido, id_pedido, id_producto, cantidad "
            + " FROM detalle_pedido";

    private static final String SQL_SELECT_BY_ID = "SELECT id_detalle_pedido, id_pedido, id_producto, cantidad"
            + " FROM detalle_pedido WHERE id_detalle_pedido = ?";

    private static final String SQL_INSERT = "INSERT INTO detalle_pedido(id_pedido, id_producto, cantidad) "
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE detalle_pedido "
            + " SET id_pedido = ?, id_producto = ?, cantidad = ? WHERE id_detalle_pedido = ?";

    private static final String SQL_DELETE = "DELETE FROM detalle_pedido WHERE id_detalle_pedido = ?";
    
    public List<Detalle_Pedido> seleccionar() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Detalle_Pedido detallePedido = null;
        List<Detalle_Pedido> detallePedidos = new ArrayList<>();
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_detalle_pedido = rs.getInt("id_detalle_pedido");
                int id_pedido = rs.getInt("id_pedido");
                int id_producto = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");

                detallePedido = new Detalle_Pedido(id_detalle_pedido, id_pedido, id_producto, cantidad);
                detallePedidos.add(detallePedido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return detallePedidos;
    }
    
     public Detalle_Pedido encontrar(Detalle_Pedido detallePedido) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, detallePedido.getIdDetallePedido());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

                int id_pedido = rs.getInt("id_pedido");
                int id_producto = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");

            detallePedido.setIdPedido(id_pedido);
            detallePedido.setIdProducto(id_producto);
            detallePedido.setCantidad(cantidad);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return detallePedido;
    }
    
    public int insertar(Detalle_Pedido detallePedido) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, detallePedido.getIdPedido());
            stmt.setInt(2, detallePedido.getIdProducto());
            stmt.setInt(3, detallePedido.getCantidad());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
      public int actualizar(Detalle_Pedido detallePedidos) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, detallePedidos.getIdPedido());
            stmt.setInt(2, detallePedidos.getIdProducto());
            stmt.setInt(3, detallePedidos.getCantidad());
            stmt.setInt(4, detallePedidos.getIdDetallePedido());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
     
      public int eliminar(Detalle_Pedido detallePedido) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, detallePedido.getIdDetallePedido());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    
}


