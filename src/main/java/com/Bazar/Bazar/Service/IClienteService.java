
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.Model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public List <Cliente> listarClientes();
    
    public String crearCliente(Cliente cliente);
    
    public Cliente buscarCliente(Long id_cliente);
    
    public String editarCliente(Long id_cliente,String nombre,String apellido,String dni);
    
    public String borrarCliente(Long id_cliente);
    
    
    
}