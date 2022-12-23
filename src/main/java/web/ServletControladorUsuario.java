package web;

import datos.ClienteDaoJDBC;
import datos.ProovedorDaoJDBC;
import datos.UsuarioDaoJDBC;
import datos.VendedorDaoJDBC;
import dominio.Cliente;
import dominio.Usuario;
import dominio.Vendedor;
import dominio.Proovedor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorUsuario")
public class ServletControladorUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarUsuario(request, response);
                    break;
                case "eliminar":
                    this.eliminarUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Usuario> usuarios = new UsuarioDaoJDBC().seleccionar();
            System.out.println("usuarios = " + usuarios);
            HttpSession sesion = request.getSession();
            //request.getRequestDispatcher("clientes.jsp").forward(request, response);
            response.sendRedirect("indexInterfaz.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void accionAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Usuario> usuarios = new UsuarioDaoJDBC().seleccionar();
            System.out.println("usuarios = " + usuarios);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuarios", usuarios);
            response.sendRedirect("panelIndex.jsp"); // aqui lo mandamos al panel de admin
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente

        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        Usuario usuario;
        try {
            usuario = new UsuarioDaoJDBC().encontrar(new Usuario(id_usuario));
            request.setAttribute("usuario", usuario);
            String jspEditar = "/WEB-INF/paginas/usuario/editarUsuario.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarUsuario(request, response);
                    break;
                case "modificar":
                    this.modificarUsuario(request, response);
                    break;
                case "login":
                    this.loginUsuario(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // usuario
            String user = request.getParameter("user");
            String email = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");

            //Creamos el objeto de cliente (modelo)
            Usuario usuario = new Usuario(user, email, contrasena);

            //Insertamos el nuevo usuario en la base de datos
            int registrosModificados = new UsuarioDaoJDBC().insertar(usuario);
            System.out.println("registrosModificados = " + registrosModificados);

            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String user = request.getParameter("user");
            String email = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");

            //Creamos el objeto de cliente (modelo)
            Usuario usuario = new Usuario(idUsuario, user, email, contrasena);

            //Modificar el  objeto en la base de datos
            int registrosModificados = new UsuarioDaoJDBC().actualizar(usuario);
            System.out.println("registrosModificados = " + registrosModificados);

            //Redirigimos hacia accion por default
            this.accionDefault(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

            //Creamos el objeto de cliente (modelo)
            Usuario usuario = new Usuario(id_usuario);

            //Eliminamos el  objeto en la base de datos
            int registrosModificados = new UsuarioDaoJDBC().eliminar(usuario);
            System.out.println("registrosModificados = " + registrosModificados);

            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loginUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario agregarCliente
            String user = request.getParameter("user");
            String contrasena = request.getParameter("contrasena");

            List<Usuario> usuarios = new UsuarioDaoJDBC().seleccionar();
            int contador = 0;
            for (Usuario usr : usuarios) {
                if (user.equals(usr.getUser()) && contrasena.equals(usr.getContrasena())) {
                    // lo llevamos al admin
                    System.out.println("LOGIN CORRECTO");
                    //aumentamos el contador cuando encontremos al usuario que se quiere logear
                    contador++;
                } else {
                    System.out.println("LOGIN INCORRECTO");
                    contador = 0;
                }
            }
            //if para determinar que accion tomar al encontrar un usuario correcto
            System.out.println(contador);
            if (contador == 1) {
                this.accionAdmin(request, response);
            } else {
                this.accionDefault(request, response);
            }
            // llevarlo al index porque no es correcto el usuario o contra

            //this.accionDefault(request, response);
            /*
            boolean usuarioValido = usuarios.stream().anyMatch(usr -> usuario.equals(usr.getUsuario()));
            boolean contrasenaValida = usuarios.stream().anyMatch(usr -> usuario.equals(usr.getContrasena()));
            System.out.println(usuarioValido);
            System.out.println(contrasenaValida);
             */
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
