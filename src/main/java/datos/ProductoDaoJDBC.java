
package datos;

import dominio.Cliente;
import dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoJDBC {
    private static final String SQL_SELECT = "SELECT id_producto, modelo, marca, precio, imagen, id_proovedor"
            + " FROM producto";

    private static final String SQL_SELECT_BY_ID = "SELECT id_producto, modelo, marca, precio, imagen, id_proovedor "
            + " FROM producto WHERE id_producto = ?";

    private static final String SQL_INSERT = "INSERT INTO producto(modelo, marca, precio, imagen, id_proovedor) "
            + " VALUES(?, ?, ?, ?, ?)";

   private static final String SQL_UPDATE = "UPDATE producto "
            + " SET modelo=?, marca=?, precio=?, imagen=?, id_proovedor=? WHERE id_producto=?";

    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_producto = ?";
    
       public List<Producto> seleccionar() throws ClassNotFoundException  {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                Double precio = rs.getDouble("precio");
                String imagen = rs.getString("imagen");
                int id_proovedor = rs.getInt("id_proovedor");

                producto = new Producto(idProducto, modelo, marca, precio, imagen, id_proovedor);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }
       
       public Producto encontrar(Producto producto) throws ClassNotFoundException  {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, producto.getIdProducto());
            rs = stmt.executeQuery();
            
            // rs.absolute(0);//nos posicionamos en el primer registro devuelto
            // rs.first();
            // producto = new Producto(idProducto, modelo, marca, precio, imagen, id_proovedor);
            // execute the query, and get a java resultset

            // iterate through the java resultset
            while (rs.next())
            {
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                Double precio = rs.getDouble("precio");
                String imagen = rs.getString("imagen");
                int id_proovedor = rs.getInt("id_proovedor");
                producto.setModelo(modelo);
                producto.setMarca(marca);
                producto.setPrecio(precio);
                producto.setImagen(imagen);
                producto.setIdProovedor(id_proovedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    }
       
        public int insertar(Producto producto) throws ClassNotFoundException  {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getModelo());
            stmt.setString(2, producto.getMarca());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setString(4, producto.getImagen());
            stmt.setInt(5, producto.getIdProovedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
        
         public int actualizar(Producto producto) throws ClassNotFoundException  {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getModelo());
            stmt.setString(2, producto.getMarca());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setString(4, producto.getImagen());
            stmt.setInt(5, producto.getIdProovedor());
            stmt.setInt(6, producto.getIdProducto());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
         
        public int eliminar(Producto producto) throws ClassNotFoundException  {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdProducto());

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
