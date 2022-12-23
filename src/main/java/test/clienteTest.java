/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import datos.ClienteDaoJDBC;
import dominio.Cliente;

public class clienteTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteDaoJDBC clientDAO = new ClienteDaoJDBC();
        
        //Insertar
        /*Cliente clientInsert = new Cliente("Jose","Perez","Ibañez","4778271639",3);
        System.out.println(clientDAO.insertar(clientInsert));*/
        
    
        
        //Actualizar
        /*Cliente clientUpdate = new Cliente(1,"Tommy","Torres","Lopez","5362736273",4);
        System.out.println(clientDAO.actualizar(clientUpdate));*/
        
        //Eliminar
       /* Cliente clientDelete = new Cliente(1);
        System.out.println(clientDAO.eliminar(clientDelete));*/
        
         // Seleccionar
       //System.out.println(clientDAO.seleccionar());
    }
    
}
