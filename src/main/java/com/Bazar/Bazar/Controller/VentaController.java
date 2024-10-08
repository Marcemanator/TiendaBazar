
package com.Bazar.Bazar.Controller;

import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Service.VentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    
    @Autowired
    VentaService Venserv;
    
    @PostMapping("/ventas/crear")
    public void crearVentas(@RequestBody Venta ven){
        
        Venserv.crearVenta(ven);
    }
    
    @GetMapping("/ventas")
    public void listarVentas(){
        Venserv.listarVentas();
    }
    
    @GetMapping("/ventas/{id_venta}")
    public void buscarVentas(@PathVariable Long codigo_venta){
        
        Venserv.buscarVenta(codigo_venta);
        
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public void editarVenta(@PathVariable Long codigo_venta,@RequestParam LocalDate fecha_venta){
        
        Venserv.editarVenta(codigo_venta, fecha_venta);
        
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable Long codigo_venta){
        
        Venserv.borrarventa(codigo_venta);
    }
    
}