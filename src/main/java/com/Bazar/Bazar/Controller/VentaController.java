
package com.Bazar.Bazar.Controller;

import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Service.VentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String crearVentas(@RequestParam List<Long>codigo_producto, @RequestParam Long id_cliente){
        
        
        Venserv.crearVenta(codigo_producto, id_cliente);
        
        return "Venta creada";
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
    public String editarVenta(@PathVariable Long codigo_venta,@RequestParam(required=false) String fecha_venta,@RequestParam(required=false) List<Long>idsproductos){
        
        Venserv.editarVenta(codigo_venta, fecha_venta,idsproductos);
        
        return "Venta editada";
        
        
        
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        
        Venserv.borrarventa(codigo_venta);
        
        return "Venta eliminada";
    }
    
    @GetMapping("venta/productos/{id_venta}")
    public List<Producto> productosVenta(@PathVariable Long id_venta){
        
        return Venserv.ventaProductos(id_venta);
    }
    
}