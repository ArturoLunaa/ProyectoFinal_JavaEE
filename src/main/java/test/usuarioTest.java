/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.ClienteDaoJDBC;
import datos.ProovedorDaoJDBC;
import datos.UsuarioDaoJDBC;
import datos.VendedorDaoJDBC;
import dominio.Cliente;
import dominio.Proovedor;
import dominio.Usuario;
import dominio.Vendedor;

/**
 *
 * @author artur
 */
public class usuarioTest {
     public static void main(String[] args) {
        UsuarioDaoJDBC usuarioDAO = new UsuarioDaoJDBC();
        ClienteDaoJDBC clientDAO = new ClienteDaoJDBC();
        VendedorDaoJDBC vendedorDAO = new VendedorDaoJDBC();
        ProovedorDaoJDBC proovedorDAO = new ProovedorDaoJDBC();
        //Insertar Usuario
        // Usuario usuarioInsert = new Usuario("Emiliano","Calzada","Morales","8372718293","ecalzada","emiliano@hotmail.com","abc123","proovedor");
        //System.out.println(usuarioDaoJDBC.insertar(usuarioInsert));
        /*int ID = usuarioDAO.insertar(usuarioInsert);
        
        //Insertar simultáneamente dependiendo el rol
        if(usuarioInsert.getRol() == "Cliente" || usuarioInsert.getRol() == "cliente"){
            Cliente clientInsert = new Cliente(usuarioInsert.getNombre(),usuarioInsert.getApellidoP(),usuarioInsert.getApellidoM(), usuarioInsert.getTelefono(),ID);
            System.out.println(clientDAO.insertar(clientInsert));
            
        }else if(usuarioInsert.getRol() == "Vendedor" || usuarioInsert.getRol() == "vendedor"){
            Vendedor vendedorInsert = new Vendedor(usuarioInsert.getNombre(),usuarioInsert.getApellidoP(),usuarioInsert.getApellidoM(), usuarioInsert.getTelefono(),ID);
            System.out.println(vendedorDAO.insertar(vendedorInsert));
            
        }else if(usuarioInsert.getRol() == "Proovedor" || usuarioInsert.getRol() == "proovedor"){
            Proovedor proovedorInsert = new Proovedor(usuarioInsert.getNombre(),usuarioInsert.getApellidoP(),usuarioInsert.getApellidoM(), usuarioInsert.getTelefono(),ID);
            System.out.println(proovedorDAO.insertar(proovedorInsert));
        }*/
        
        //Actualizar Usuario
        /*Usuario usuarioUpdate = new Usuario(7,"J","Perez","apellido","1111111111|","pjimenez","prueba@hotmail.com","abc123","Proovedor");
         System.out.println(usuarioDAO.actualizar(usuarioUpdate));
        /*if(usuarioDAO.actualizar(usuarioUpdate) == 1 && (usuarioUpdate.getRol() == "Proovedor" || usuarioUpdate.getRol() == "proovedor")){
            Proovedor proovedorUpdate = new Proovedor(usuarioUpdate.getNombre(),usuarioUpdate.getApellidoP(),usuarioUpdate.getApellidoM(), usuarioUpdate.getTelefono(),usuarioUpdate.getId_usuario());
            System.out.println(proovedorDAO.actualizar(proovedorUpdate));
        } */       
        //Eliminar
        /*Usuario usuarioDelete = new Usuario(3);
        System.out.println(usuarioDAO.eliminar(usuarioDelete));
        
         // Seleccionar
        System.out.println(usuarioDAO.seleccionar());*/
    }
}
