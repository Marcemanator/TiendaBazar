package com.Bazar.Bazar.Controller;

import com.Bazar.Bazar.DTO.BazarDTO;
import com.Bazar.Bazar.Model.Cliente;
import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Repository.ClienteRepository;
import com.Bazar.Bazar.Repository.ProductoRepository;
import com.Bazar.Bazar.Repository.VentaRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
   

    @GetMapping("ventas/mayor_venta")
    public BazarDTO bazardto( ) {
        int pr=0;
        
        List<Venta>ventas=VenRepo.findAll();
        List<Venta>v=new ArrayList();
        
        Venta ventaTotAlto=Collections.max(ventas, Comparator.comparing(Venta::getTotal));
       
      
          
           BazarDTO bzdto=new BazarDTO();
           
           
           pr++;
           bzdto.setCodigo_venta(ventaTotAlto.getCodigo_venta());
           bzdto.setNombrecliente(ventaTotAlto.getCliente().getNombre());
           bzdto.setApellidoCliente(ventaTotAlto.getCliente().getApellido());
           bzdto.setCantidadProductos(ventaTotAlto.getListaproductos().size());
           bzdto.setTotal(ventaTotAlto.getTotal());
           
           
           return bzdto;
    
    
    }
}

    


