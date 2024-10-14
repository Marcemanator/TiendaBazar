
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
        if(nombre!=null && !nombre.isEmpty()){
        clienteNuevo.setNombre(nombre);}
        
        else{clienteNuevo.setNombre(cli.getNombre());}
        
        if(apellido!=null && !apellido.isEmpty()){
        clienteNuevo.setApellido(apellido);}
        
        else{clienteNuevo.setDni(cli.getApellido());}
        
        if(dni!=null && !dni.isEmpty()){
        clienteNuevo.setDni(dni);}
        
        else{clienteNuevo.setDni(cli.getDni());}
        
        Clirepo.save(clienteNuevo);
       
        return "Cliente editado";
        
        
    }

    @Override
    public String borrarCliente(Long id_cliente) {
        Clirepo.deleteById(id_cliente);
        
        return "Cliente borrado";
      
        
    }
        
        
        
  
    
}