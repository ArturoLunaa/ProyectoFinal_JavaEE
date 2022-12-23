/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import datos.VendedorDaoJDBC;
import dominio.Vendedor;

/**
 *
 * @author artur
 */
public class vendedorTest {

    public static void main(String[] args) {
        VendedorDaoJDBC vendedorDAO = new VendedorDaoJDBC();
        
        //Insertar
        /*Vendedor vendedorInsert = new Vendedor("Juan","Lopez","Ibañez","4325171639",3);
        System.out.println(vendedorDAO.insertar(vendedorInsert));*/
        
        //Actualizar
        /*Vendedor vendedorUpdate = new Vendedor(2,"Juan","Lopez","Lopez","4325171639",3);
        System.out.println(vendedorDAO.actualizar(vendedorUpdate));*/
        
        //Eliminar
        /*Vendedor vendedorDelete = new Vendedor(2);
        System.out.println(vendedorDAO.eliminar(vendedorDelete));*/
        
         // Seleccionar
        //System.out.println(vendedorDAO.seleccionar());
    }
    
}
