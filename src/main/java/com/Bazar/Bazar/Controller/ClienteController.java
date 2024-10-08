
package com.Bazar.Bazar.Controller;

import com.Bazar.Bazar.Model.Cliente;
import com.Bazar.Bazar.Service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ClienteController {
    
    @Autowired
    ClienteService Cliserv;
    
    
    
    @PostMapping("/clientes/crear")
   public void crearCliente(Cliente cli){
       
       Cliserv.crearCliente(cli);
       
   }
    
    
   @GetMapping("/clientes")
   public  List<Cliente>listarClientes(){
       
      return Cliserv.listarClientes();
       
   }
   
   
   @GetMapping("/clientes/{id_cliente}")
   public void buscarCliente(@PathVariable Long id_cliente){
       
       Cliserv.buscarCliente(id_cliente);
       
   }
   
   @PutMapping("/clientes/editar/{id_cliente}")
   public void editarCliente(@PathVariable Long id_cliente,@RequestParam String nombre,@RequestParam String apellido, @RequestParam String dni){
       
       Cliserv.editarCliente(id_cliente, nombre, apellido, dni);
       
   }
   
   @DeleteMapping("/clientes/eliminar/{id_cliente}")
   public void eliminarCliente(@PathVariable Long id_cliente){
       
       Cliserv.borrarCliente(id_cliente);
   }
   
   
    
    
}