
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import dominio.Pedido;
import dominio.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoJDBC {
   private static final String SQL_SELECT = "SELECT id_pedido, fecha, estado, fechaEnvio, id_cliente, id_vendedor "
            + " FROM pedido";

    private static final String SQL_SELECT_BY_ID = "SELECT id_pedido, fecha, estado, fechaEnvio, id_cliente, id_vendedor"
            + " FROM pedido WHERE id_pedido = ?";

    private static final String SQL_INSERT = "INSERT INTO pedido(fecha, estado, fechaEnvio, id_cliente, id_vendedor) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE pedido "
            + " SET fecha = ?, estado = ?, fechaEnvio = ?, id_cliente = ?, id_vendedor = ? WHERE id_pedido = ?";

    private static final String SQL_DELETE = "DELETE FROM pedido WHERE id_pedido = ?";
    
    public List<Pedido> seleccionar() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                String fecha = rs.getString("fecha");
                String estado = rs.getString("estado");
                String fechaEnvio = rs.getString("fechaEnvio");
                int id_cliente = rs.getInt("id_cliente");
                int id_vendedor = rs.getInt("id_vendedor");

                pedido = new Pedido(idPedido, fecha, estado, fechaEnvio, id_cliente, id_vendedor);
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pedidos;
    }
    
     public Pedido encontrar(Pedido pedido) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, pedido.getIdPedido());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String fecha = rs.getString("fecha");
            String estado = rs.getString("estado");
            String fechaEnvio = rs.getString("fechaEnvio");
            int id_cliente = rs.getInt("id_cliente");
            int id_vendedor = rs.getInt("id_vendedor");

            pedido.setFecha(fecha);
            pedido.setEstado(estado);
            pedido.setFechaEnvio(fechaEnvio);
            pedido.setIdCliente(id_cliente);
            pedido.setIdVendedor(id_vendedor);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pedido;
    }
    
    public int insertar(Pedido pedido) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, pedido.getFecha());
            stmt.setString(2, pedido.getEstado());
            stmt.setString(3, pedido.getFechaEnvio());
            stmt.setInt(4, pedido.getIdCliente());
            stmt.setInt(5, pedido.getIdVendedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
      public int actualizar(Pedido pedidos) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pedidos.getFecha());
            stmt.setString(2, pedidos.getEstado());
            stmt.setString(3, pedidos.getFechaEnvio());
            stmt.setInt(4, pedidos.getIdCliente());
            stmt.setInt(5, pedidos.getIdVendedor());
            stmt.setInt(6, pedidos.getIdPedido());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
     
      public int eliminar(Pedido pedido) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pedido.getIdPedido());

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
