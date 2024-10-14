
package com.Bazar.Bazar.Controller;

import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
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
    public List<Producto> listarProductos(){
        
        
        
        return Proserv.listarProductos();
        
        
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public Producto buscarProducto(@PathVariable Long codigo_producto){
        
        
        Producto producto=Proserv.buscarProducto(codigo_producto);
        
        return producto;
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public String editarProducto(@PathVariable Long codigo_producto,@RequestParam (required=false) String nombre, @RequestParam(required=false) String marca,
            @RequestParam (required=false) Double precio,@RequestParam (required=false)  Double stock,@RequestParam  (required=false) List<Venta>venta){
            
            Proserv.editarproducto(codigo_producto, nombre, marca, precio, stock,venta);
    
            return "producto editado";
   
}
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
        Proserv.borrarproducto(codigo_producto);
        
        return "producto eliminado";
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto>faltaStock(){
        
       return Proserv.faltaStock();
        
    }

}