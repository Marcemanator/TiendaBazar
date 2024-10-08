
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.Model.Cliente;
import com.Bazar.Bazar.Repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService implements IClienteService {
    
    
    @Autowired
    ClienteRepository Clirepo;

    @Override
    public List<Cliente> listarClientes() {
        
        
        
         List<Cliente>listarCliente=Clirepo.findAll();
         
         return listarCliente;
    }
        
        


    

    @Override
    public String crearCliente(Cliente cliente) {
        
        Clirepo.save(cliente);
                
        return "Cliente creado";
        
       
        
       
    }

    @Override
    public Cliente buscarCliente(Long id_cliente) {
        
        Cliente cliente=Clirepo.findById(id_cliente).orElse(null);
        
        
        return cliente;
       
    }

    @Override
    public String editarCliente(Long id_cliente, String nombre, String apellido, String dni) {
        Cliente cli=Clirepo.findById(id_cliente).orElse(null);
        Cliente clienteNuevo=new Cliente();
        clienteNuevo.setId_cliente(cli.getId_cliente());
        clienteNuevo.setNombre(nombre);
        clienteNuevo.setApellido(apellido);
        clienteNuevo.setDni(dni);
        
        Clirepo.save(clienteNuevo);
       
        return "Cliente editado";
        
        
    }

    @Override
    public String borrarCliente(Long id_cliente) {
        Clirepo.deleteById(id_cliente);
        
        return "Cliente borrado";
      
        
    }
        
        
        
  
    
}