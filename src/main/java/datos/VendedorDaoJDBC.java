
package datos;

import dominio.Cliente;
import dominio.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDaoJDBC {
    private static final String SQL_SELECT = "SELECT id_vendedor, nombre, apellidoP, apellidoM, telefono "
            + " FROM vendedor";

    private static final String SQL_SELECT_BY_ID = "SELECT id_vendedor, nombre, apellidoP, apellidoM, telefono "
            + " FROM vendedor WHERE id_vendedor = ?";

    private static final String SQL_INSERT = "INSERT INTO vendedor(nombre, apellidoP, apellidoM, telefono) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE vendedor "
            + " SET nombre=?, apellidoP=?, apellidoM=?, telefono=? WHERE id_vendedor=?";

    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE id_vendedor = ?";

    public List<Vendedor> seleccionar() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idVendedor = rs.getInt("id_vendedor");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String telefono = rs.getString("telefono");

                vendedor = new Vendedor(idVendedor, nombre, apellidoP, apellidoM,telefono);
                vendedores.add(vendedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vendedores;
    }

    public Vendedor encontrar(Vendedor vendedor) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, vendedor.getIdVendedor());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellidoP = rs.getString("apellidoP");
            String apellidoM = rs.getString("apellidoM");
            String telefono = rs.getString("telefono");

            vendedor.setNombre(nombre);
            vendedor.setApellidoP(apellidoP);
            vendedor.setApellidoM(apellidoM);
            vendedor.setTelefono(telefono);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vendedor;
    }

    public int insertar(Vendedor vendedor) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.getNombre());
            stmt.setString(2, vendedor.getApellidoP());
            stmt.setString(3, vendedor.getApellidoM());
            stmt.setString(4, vendedor.getTelefono());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Vendedor vendedor) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.getNombre());
            stmt.setString(2, vendedor.getApellidoP());
            stmt.setString(3, vendedor.getApellidoM());
            stmt.setString(4, vendedor.getTelefono());
            stmt.setInt(5, vendedor.getIdVendedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Vendedor vendedor) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getIdVendedor());

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
