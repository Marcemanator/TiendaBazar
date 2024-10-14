
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ClienteController {
    
    @Autowired
    ClienteService Cliserv;
    
    
    
    @PostMapping("/clientes/crear")
   public String crearCliente(@RequestBody Cliente cli){
       
       Cliserv.crearCliente(cli);
       
       return "Cliente creado";
   }
    
    
   @GetMapping("/clientes")
   public  List<Cliente>listarClientes(){
       
      return Cliserv.listarClientes();
       
   }
   
   
   @GetMapping("/clientes/{id_cliente}")
   public Cliente buscarCliente(@PathVariable Long id_cliente){
       Cliente cliente= Cliserv.buscarCliente(id_cliente);
       
       return cliente;
      
       
   }
   
   @PutMapping("/clientes/editar/{id_cliente}")
   public String editarCliente(@PathVariable Long id_cliente,@RequestParam (required=false)String nombre,
           @RequestParam (required=false) String apellido, @RequestParam (required=false)String dni){
       
       Cliserv.editarCliente(id_cliente, nombre, apellido, dni);
       
       return "Cliente editado";
               
   }
   
   @DeleteMapping("/clientes/eliminar/{id_cliente}")
   public String eliminarCliente(@PathVariable Long id_cliente){
       
       Cliserv.borrarCliente(id_cliente);
       return "cliente borrado";
       
   }
   
   
    
    
}