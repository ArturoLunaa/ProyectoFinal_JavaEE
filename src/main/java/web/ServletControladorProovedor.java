
package web;

import datos.ClienteDaoJDBC;
import datos.ProovedorDaoJDBC;
import dominio.Cliente;
import dominio.Proovedor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControladorProovedor")
public class ServletControladorProovedor extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarProovedor(request, response);
                    break;
                case "eliminar":
                    this.eliminarProovedor(request, response);
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
            List<Proovedor> proovedor = new ProovedorDaoJDBC().seleccionar();
            System.out.println("proovedores = " + proovedor);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("proovedores", proovedor);
            //request.getRequestDispatcher("clientes.jsp").forward(request, response);
            response.sendRedirect("proovedores.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProovedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void editarProovedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        
        int idProovedor = Integer.parseInt(request.getParameter("idProovedor"));
        Proovedor proovedor;
        try {
            proovedor = new ProovedorDaoJDBC().encontrar(new Proovedor(idProovedor));
            request.setAttribute("proovedor", proovedor);
        String jspEditar = "/WEB-INF/paginas/proovedor/editarProovedor.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProovedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProovedor(request, response);
                    break;
                case "modificar":
                    this.modificarProovedor(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarProovedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario agregarCliente
            String nombre = request.getParameter("nombre");
            String apellidoP = request.getParameter("apellidoP");
            String apellidoM = request.getParameter("apellidoM");
            String telefono = request.getParameter("telefono");
            
            //Creamos el objeto de cliente (modelo)
            Proovedor proovedor = new Proovedor(nombre, apellidoP, apellidoM, telefono);
            
            //Insertamos el nuevo objeto en la base de datos
            int registrosModificados = new ProovedorDaoJDBC().insertar(proovedor);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProovedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarProovedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idProovedor = Integer.parseInt(request.getParameter("idProovedor"));
            String nombre = request.getParameter("nombre");
            String apellidoP = request.getParameter("apellidoP");
            String apellidoM = request.getParameter("apellidoM");
            String telefono = request.getParameter("telefono");
            
            //Creamos el objeto de cliente (modelo)
            Proovedor proovedor = new Proovedor(idProovedor, nombre, apellidoP, apellidoM, telefono);
            
            //Modificar el  objeto en la base de datos
            int registrosModificados = new ProovedorDaoJDBC().actualizar(proovedor);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProovedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void eliminarProovedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idProovedor = Integer.parseInt(request.getParameter("idProovedor"));
            
            //Creamos el objeto de cliente (modelo)
            Proovedor proovedor = new Proovedor(idProovedor);
            
            //Eliminamos el  objeto en la base de datos
            int registrosModificados = new ProovedorDaoJDBC().eliminar(proovedor);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProovedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
