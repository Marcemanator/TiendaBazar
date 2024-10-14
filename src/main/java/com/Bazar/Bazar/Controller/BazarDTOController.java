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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BazarDTOController {

    @Autowired
    ClienteRepository CliRepo;

    @Autowired
    ProductoRepository ProRepo;

    @Autowired
    VentaRepository VenRepo;
   

    @GetMapping("/dto")
    public List<BazarDTO> bazardto( @RequestParam Long idcliente) {
        BazarDTO bazar = new BazarDTO();
        List<BazarDTO> bdto = new ArrayList();

        List<Cliente> clientes = CliRepo.findAll();
        List<Producto> productos = ProRepo.findAll();
        List<Venta> ventas = VenRepo.findAll();

        for (Venta ven : ventas) {
            int cantidadproductos=0;
        
            for (Producto pro : productos) {
                cantidadproductos++;
                for (Cliente cli : clientes) {
                    if(idcliente.equals(cli.getId_cliente())){
                        
                    

                    bazar.setCodigo_venta(ven.getCodigo_venta());
                    bazar.setTotal(ven.getTotal());
                 

                    
                    bazar.setCantidadProductos(cantidadproductos);
                    

                    bazar.setNombrecliente(cli.getNombre());
                    bazar.setApellidoCliente(cli.getApellido());
                    bdto.add(bazar);
                    break;

                }
            }

       
        
        }

  
        }
          return bdto;
    }
}

