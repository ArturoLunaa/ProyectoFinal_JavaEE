
package web;

import datos.ClienteDaoJDBC;
import datos.Detalle_PedidoDaoJDBC;
import datos.PedidoDaoJDBC;
import dominio.Cliente;
import dominio.Detalle_Pedido;
import dominio.Pedido;
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

@WebServlet("/ServletControladorPedido")
public class ServletControladorPedido extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPedido(request, response);
                    break;
                case "editarDetalle":
                    this.editarDetalle(request, response);
                    break;
                case "eliminar":
                    this.eliminarPedido(request, response);
                    break;
               case "eliminarDetalle":
                    this.eliminarDetalle(request, response);
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
            List<Pedido> pedidos = new PedidoDaoJDBC().seleccionar();
            List<Detalle_Pedido> detallePedidos = new Detalle_PedidoDaoJDBC().seleccionar();
            System.out.println("pedidos = " + pedidos);
            System.out.println("detallePedidos = " + detallePedidos);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("pedidos", pedidos);
            sesion.setAttribute("detallePedidos", detallePedidos);
            //request.getRequestDispatcher("clientes.jsp").forward(request, response);
            response.sendRedirect("pedidos.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void editarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        Pedido pedido;
        try {
            pedido = new PedidoDaoJDBC().encontrar(new Pedido(idPedido));
            request.setAttribute("pedido", pedido);
        String jspEditar = "/WEB-INF/paginas/pedido/editarPedido.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        private void editarDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        
        int idDetallePedido = Integer.parseInt(request.getParameter("idDetallePedido"));
        Detalle_Pedido detallePedido;
        try {
            detallePedido = new Detalle_PedidoDaoJDBC().encontrar(new Detalle_Pedido(idDetallePedido));
            request.setAttribute("detallePedido", detallePedido);
        String jspEditar = "/WEB-INF/paginas/detallePedido/editarDetallePedido.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarPedido(request, response);
                    break;
                case "insertarDetalle":
                    this.insertarDetalle(request, response);
                    break;
                case "modificar":
                    this.modificarPedido(request, response);
                    break;
                case "modificarDetalle":
                    this.modificarDetalle(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario agregarCliente
            String fecha = request.getParameter("fecha");
            String estado = request.getParameter("estado");
            String fechaEnvio = request.getParameter("fechaEnvio");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idVendedor = Integer.parseInt(request.getParameter("idVendedor"));
            
            //Creamos el objeto de cliente (modelo)
            Pedido pedido = new Pedido(fecha, estado, fechaEnvio, idCliente, idVendedor);
            
            //Insertamos el nuevo objeto en la base de datos
            int registrosModificados = new PedidoDaoJDBC().insertar(pedido);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void insertarDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario agregarCliente
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            //Creamos el objeto de cliente (modelo)
            Detalle_Pedido detallePedido = new Detalle_Pedido(idPedido, idProducto, cantidad);
            
            //Insertamos el nuevo objeto en la base de datos
            int registrosModificados = new Detalle_PedidoDaoJDBC().insertar(detallePedido);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            String fecha = request.getParameter("fecha");
            String estado = request.getParameter("estado");
            String fechaEnvio = request.getParameter("fechaEnvio");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idVendedor = Integer.parseInt(request.getParameter("idVendedor"));
            
            //Creamos el objeto de cliente (modelo)
            Pedido pedido = new Pedido(idPedido, fecha, estado, fechaEnvio, idCliente, idVendedor);
            
            //Modificar el  objeto en la base de datos
            int registrosModificados = new PedidoDaoJDBC().actualizar(pedido);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void modificarDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idDetallePedido = Integer.parseInt(request.getParameter("idDetallePedido"));
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            
            //Creamos el objeto de cliente (modelo)
            Detalle_Pedido detallePedido = new Detalle_Pedido(idDetallePedido, idPedido, idProducto, cantidad);
            
            //Modificar el  objeto en la base de datos
            int registrosModificados = new Detalle_PedidoDaoJDBC().actualizar(detallePedido);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private void eliminarPedido(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idPedido = Integer.parseInt(request.getParameter("idPedido"));
            
            //Creamos el objeto de cliente (modelo)
            Pedido pedido = new Pedido(idPedido);
            
            //Eliminamos el  objeto en la base de datos
            int registrosModificados = new PedidoDaoJDBC().eliminar(pedido);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
            private void eliminarDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recuperamos los valores del formulario editarCliente
            int idDetallePedido = Integer.parseInt(request.getParameter("idDetallePedido"));
            
            //Creamos el objeto de cliente (modelo)
            Detalle_Pedido detallePedido = new Detalle_Pedido(idDetallePedido);
            
            //Eliminamos el  objeto en la base de datos
            int registrosModificados = new Detalle_PedidoDaoJDBC().eliminar(detallePedido);
            System.out.println("registrosModificados = " + registrosModificados);
            
            //Redirigimos hacia accion por default
            this.accionDefault(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletControladorPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
