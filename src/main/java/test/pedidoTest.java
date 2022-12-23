/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.ClienteDaoJDBC;
import datos.PedidoDaoJDBC;
import dominio.Cliente;
import dominio.Pedido;

/**
 *
 * @author artur
 */
public class pedidoTest {
    public static void main(String[] args) {
        PedidoDaoJDBC pedidoDAO = new PedidoDaoJDBC();
        
        //Insertar
        /*Pedido pedidoInsert = new Pedido("23/11/2022","En camino","23/11/2022",4,1);
        System.out.println(pedidoDAO.insertar(pedidoInsert));*/
        
    
        
        //Actualizar
        /*Pedido pedidoUpdate = new Pedido(2,"23/11/2022","Enviado","23/11/2022",4,1);
        System.out.println(pedidoDAO.actualizar(pedidoUpdate));*/
        
        //Eliminar
        /*Pedido pedidoDelete = new Pedido(2);
        System.out.println(pedidoDAO.eliminar(pedidoDelete));*/
        
         // Seleccionar
       //System.out.println(pedidoDAO.seleccionar());
    }
}
