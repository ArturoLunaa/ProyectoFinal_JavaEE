
package test;

import datos.ProductoDaoJDBC;
import dominio.Producto;

/**
 *
 * @author artur
 */
public class productoTest {
    public static void main(String[] args) {
        ProductoDaoJDBC productoDAO = new ProductoDaoJDBC();
        
        //Insertar
        /*Producto productoInsert = new Producto("AirMax","Nike",4000.00,"URL-IMG",1);
        System.out.println(productoDAO.insertar(productoInsert));*/
        
        //Actualizar
        /*Producto productoUpdate = new Producto(2,"AirForce","Nike",4500.80,"URL-IMG",1);
        System.out.println(productoDAO.actualizar(productoUpdate));*/
        
        //Eliminar
       /* Producto productoDelete = new Producto(2);
        System.out.println(productoDAO.eliminar(productoDelete));*/
        
         // Seleccionar
        //System.out.println(productoDAO.seleccionar());
    }
}
