
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.Model.Producto;
import java.util.List;


public interface IProductoService {
    
    public List <Producto> listarProductos();
    
    public String crearProducto(Producto producto);
    
    public Producto buscarProducto(Long id_producto);
    
    public String editarproducto(Long id_producto,String nombre,String marca,Double precio,Double stock);
    
    public String borrarproducto(Long id_producto);
    
    
}