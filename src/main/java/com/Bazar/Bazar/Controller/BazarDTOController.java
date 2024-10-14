
package com.Bazar.Bazar.Controller;
import com.Bazar.Bazar.DTO.BazarDTO;
import com.Bazar.Bazar.Model.Cliente;
import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Repository.ClienteRepository;
import com.Bazar.Bazar.Repository.ProductoRepository;
import com.Bazar.Bazar.Repository.VentaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BazarDTOController {
    
    ClienteRepository CliRepo;
    
    ProductoRepository ProRepo;
    
    VentaRepository VenRepo;
    Double cantidadproductos=0.0;
    
    
  public List<BazarDTO> bazardto(BazarDTO bazar){
      List<BazarDTO>bdto=new ArrayList();
      
      List<Cliente>clientes=CliRepo.findAll();
      List<Producto>productos=ProRepo.findAll();
      List<Venta>ventas=VenRepo.findAll();
      
      for(Venta ven:ventas){
          bazar.setCodigo_venta(ven.getCodigo_venta());
          bazar.setTotal(ven.getTotal());
          bdto.add(bazar); }
      for (Producto pro: productos ){
           cantidadproductos=+1.0;
           bazar.setCantidadProductos(cantidadproductos);
           bdto.add(bazar);}
      for(Cliente cli: clientes){
          bazar.setNombrecliente(cli.getNombre());
          bazar.setApellidoCliente(cli.getApellido());
          bdto.add(bazar);
          
      }
          
         return bdto;
      
      
  }
    
    
}