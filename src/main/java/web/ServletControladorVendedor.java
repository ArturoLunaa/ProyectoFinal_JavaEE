
package web;

import datos.VendedorDaoJDBC;
import dominio.Vendedor;
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

@WebServlet("/ServletControladorVendedor")
public class ServletControladorVendedor extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarVendedor(request, response);
                    break;
                case "eliminar":
                    this.eliminarVendedor(request, response);
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
            List<Vendedor> vendedores = new VendedorDaoJDBC().seleccionar();
            System.out.println("vendedores = " + vendedores);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("vendedores", vendedores);
            //request.getRequestDispatcher("clientes.jsp").forward(request, response);
            response.sendRedirect("vendedores.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void editarVendedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el id
        int idVendedor = Integer.parseInt(request.getParameter("idVendedor"));
        Vendedor vendedor;
        try {
            vendedor = new VendedorDaoJDBC().encontrar(new Vendedor(idVendedor));
            request.setAttribute("vendedor", vendedor);
        String jspEditar = "/WEB-INF/paginas/vendedor/editarVendedor.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarVendedor(request, response);
                    break;
                case "modificar":
                    this.modificarVendedor(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarVendedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario agregarCliente
            String nombre = request.getParameter("nombre");
            String apellidoP = request.getParameter("apellidoP");
            String apellidoM = request.getParameter("apellidoM");
            String telefono = request.getParameter("telefono");
            
            //Creamos el objeto de cliente (modelo)
            Vendedor vendedor = new Vendedor(nombre, apellidoP, apellidoM, telefono);
            
            //Insertamos el nuevo objeto en la base de datos
            int registrosModificados = new VendedorDaoJDBC().insertar(vendedor);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarVendedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idVendedor = Integer.parseInt(request.getParameter("idVendedor"));
            String nombre = request.getParameter("nombre");
            String apellidoP = request.getParameter("apellidoP");
            String apellidoM = request.getParameter("apellidoM");
            String telefono = request.getParameter("telefono");
            
            //Creamos el objeto de cliente (modelo)
            Vendedor vendedor = new Vendedor(idVendedor, nombre, apellidoP, apellidoM, telefono);
            
            //Modificar el  objeto en la base de datos
            int registrosModificados = new VendedorDaoJDBC().actualizar(vendedor);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void eliminarVendedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idVendedor = Integer.parseInt(request.getParameter("idVendedor"));
            
            //Creamos el objeto de cliente (modelo)
            Vendedor vendedor = new Vendedor(idVendedor);
            
            //Eliminamos el  objeto en la base de datos
            int registrosModificados = new VendedorDaoJDBC().eliminar(vendedor);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
