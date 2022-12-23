
package datos;

import dominio.Cliente;
import dominio.Proovedor;
import dominio.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProovedorDaoJDBC {
    private static final String SQL_SELECT = "SELECT id_proovedor, nombre, apellidoP, apellidoM, telefono"
            + " FROM proovedor";

    private static final String SQL_SELECT_BY_ID = "SELECT id_proovedor, nombre, apellidoP, apellidoM, telefono "
            + " FROM proovedor WHERE id_proovedor = ?";
    
     private static final String SQL_SELECT_BY_ID_USER = "SELECT id_proovedor "
            + " FROM proovedor WHERE id_usuarioP = ?";

    private static final String SQL_INSERT = "INSERT INTO proovedor(nombre, apellidoP, apellidoM, telefono) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE proovedor "
            + " SET nombre=?, apellidoP=?, apellidoM=?, telefono=? WHERE id_proovedor=?";

    private static final String SQL_DELETE = "DELETE FROM proovedor WHERE id_proovedor = ?";
    
       public List<Proovedor> seleccionar() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proovedor proovedor = null;
        List<Proovedor> proovedores = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProovedor = rs.getInt("id_proovedor");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String telefono = rs.getString("telefono");

                proovedor = new Proovedor(idProovedor, nombre, apellidoP, apellidoM,telefono);
                proovedores.add(proovedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proovedores;
    }
       
       public Proovedor encontrar(Proovedor proovedor) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, proovedor.getIdProovedor());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellidoP = rs.getString("apellidoP");
            String apellidoM = rs.getString("apellidoM");
            String telefono = rs.getString("telefono");

            proovedor.setNombre(nombre);
            proovedor.setApellidoP(apellidoP);
            proovedor.setApellidoM(apellidoM);
            proovedor.setTelefono(telefono);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proovedor;
    }
       
        public int insertar(Proovedor proovedor) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proovedor.getNombre());
            stmt.setString(2, proovedor.getApellidoP());
            stmt.setString(3, proovedor.getApellidoM());
            stmt.setString(4, proovedor.getTelefono());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
        
        public int actualizar(Proovedor proovedor)  throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, proovedor.getNombre());
            stmt.setString(2, proovedor.getApellidoP());
            stmt.setString(3, proovedor.getApellidoM());
            stmt.setString(4, proovedor.getTelefono());
            stmt.setInt(5, proovedor.getIdProovedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
        
        public int eliminar(Proovedor proovedor)  throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, proovedor.getIdProovedor());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
        
        public int obtenerIdUserP(Proovedor proovedor)  throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID_USER);
            rs = stmt.executeQuery();
            if(rs.next()){
                rows = rs.getInt(proovedor.getIdProovedor());
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
