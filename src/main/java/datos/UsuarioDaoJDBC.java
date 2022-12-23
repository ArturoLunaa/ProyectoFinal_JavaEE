package datos;

import dominio.Cliente;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_usuario, user, correo, contrasena "
            + " FROM usuario";

    private static final String SQL_SELECT_BY_ID = "SELECT id_usuario, user, correo, contrasena "
            + " FROM usuario WHERE id_usuario = ?";

    private static final String SQL_INSERT = "INSERT INTO usuario(user, correo, contrasena ) "
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE usuario "
            + " SET user=?, correo=?, contrasena=? WHERE id_usuario=?";

    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public List<Usuario> seleccionar() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String user = rs.getString("user");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contrasena");

                usuario = new Usuario(idUsuario, user, correo, contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public Usuario encontrar(Usuario usuario) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, usuario.getId_usuario());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String user = rs.getString("user");
            String correo = rs.getString("correo");
            String contrasena = rs.getString("contrasena");

            usuario.setUser(user);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }

    public int insertar(Usuario usuario) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
           conn = Conexion.getConnection();
           /* stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellidoP());
            stmt.setString(3, usuario.getApellidoM());
            stmt.setString(4, usuario.getTelefono());
            stmt.setString(5, usuario.getUsuario());
            stmt.setString(6, usuario.getCorreo());
            stmt.setString(7, usuario.getContrasena());
            stmt.setString(8, usuario.getRol());

            rows = stmt.executeUpdate();*/

            stmt = conn.prepareStatement(SQL_INSERT, stmt.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int lastInsertId = rs.getInt(1);
                
                return lastInsertId;
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Usuario usuario) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE, stmt.RETURN_GENERATED_KEYS);
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setInt(4, usuario.getId_usuario());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int lastInsertId = rs.getInt(1);
                
                return lastInsertId;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Usuario usuario) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId_usuario());

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
