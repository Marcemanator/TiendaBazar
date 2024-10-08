
package com.Bazar.Bazar.Controller;

import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Service.ProductoService;
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
public class ProductoController {
    
    
    @Autowired
    ProductoService Proserv;
    
    
    
    @PostMapping("productos/crear")
    public void crearProducto(@RequestBody Producto pro){
        
        Proserv.crearProducto(pro);
    }
    
    @GetMapping("/productos")
    public void listarProductos(){
        
        Proserv.listarProductos();
        
        
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public void buscarProducto(@PathVariable Long codigo_producto){
        
        
        Proserv.buscarProducto(codigo_producto);
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public void editarProducto(@PathVariable Long codigo_producto,@RequestParam String nombre, @RequestParam String marca,@RequestParam Double precio,@RequestParam Double stock){
            
            Proserv.editarproducto(codigo_producto, nombre, marca, precio, stock);
    
    
}
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto){
        Proserv.borrarproducto(codigo_producto);
    }

}