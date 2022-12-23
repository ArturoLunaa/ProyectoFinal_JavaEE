
package web;

import datos.ClienteDaoJDBC;
import datos.ProductoDaoJDBC;
import dominio.Cliente;
import dominio.Producto;
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

@WebServlet("/ServletControladorProducto")
public class ServletControladorProducto extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarProducto(request, response);
                    break;
                case "eliminar":
                    this.eliminarProducto(request, response);
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
            List<Producto> productos = new ProductoDaoJDBC().seleccionar();
            System.out.println("productos = " + productos);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("productos", productos);
            //request.getRequestDispatcher("clientes.jsp").forward(request, response);
            response.sendRedirect("productos.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void editarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto producto;
        try {
            producto = new ProductoDaoJDBC().encontrar(new Producto(idProducto));
            request.setAttribute("producto", producto);
        String jspEditar = "/WEB-INF/paginas/producto/editarProducto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProducto(request, response);
                    break;
                case "modificar":
                    this.modificarProducto(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario agregarCliente
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            double precio = Double.parseDouble(request.getParameter("precio"));
            String imagen = request.getParameter("imagen");
            int idProovedor = Integer.parseInt(request.getParameter("idProovedor"));
            
            //Creamos el objeto de cliente (modelo)
            Producto producto = new Producto(modelo, marca, precio, imagen, idProovedor);
            
            //Insertamos el nuevo objeto en la base de datos
            int registrosModificados = new ProductoDaoJDBC().insertar(producto);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            double precio = Double.parseDouble(request.getParameter("precio"));
            String imagen = request.getParameter("imagen");
            int idProovedor = Integer.parseInt(request.getParameter("idProovedor"));
            
            //Creamos el objeto de cliente (modelo)
            Producto producto = new Producto(idProducto ,modelo, marca, precio, imagen, idProovedor);
            
            //Modificar el  objeto en la base de datos
            int registrosModificados = new ProductoDaoJDBC().actualizar(producto);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            
            //Creamos el objeto de cliente (modelo)
            Producto producto = new Producto(idProducto);
            
            //Eliminamos el  objeto en la base de datos
            int registrosModificados = new ProductoDaoJDBC().eliminar(producto);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
