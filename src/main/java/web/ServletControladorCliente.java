package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControladorCliente")
public class ServletControladorCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
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
            List<Cliente> clientes = new ClienteDaoJDBC().seleccionar();
            System.out.println("clientes = " + clientes);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("clientes", clientes);
            //request.getRequestDispatcher("clientes.jsp").forward(request, response);
            response.sendRedirect("clientes.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente;
        try {
            cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
            request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario agregarCliente
            String nombre = request.getParameter("nombre");
            String apellidoP = request.getParameter("apellidoP");
            String apellidoM = request.getParameter("apellidoM");
            String telefono = request.getParameter("telefono");
            
            //Creamos el objeto de cliente (modelo)
            Cliente cliente = new Cliente(nombre, apellidoP, apellidoM, telefono);
            
            //Insertamos el nuevo objeto en la base de datos
            int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String nombre = request.getParameter("nombre");
            String apellidoP = request.getParameter("apellidoP");
            String apellidoM = request.getParameter("apellidoM");
            String telefono = request.getParameter("telefono");
            
            //Creamos el objeto de cliente (modelo)
            Cliente cliente = new Cliente(idCliente, nombre, apellidoP, apellidoM, telefono);
            
            //Modificar el  objeto en la base de datos
            int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            
            //Creamos el objeto de cliente (modelo)
            Cliente cliente = new Cliente(idCliente);
            
            //Eliminamos el  objeto en la base de datos
            int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
