
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Repository.ProductoRepository;
import com.Bazar.Bazar.Repository.VentaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    ProductoRepository ProductRepo;
    
    @Autowired
    VentaRepository VentaRepo;

    @Override
    public List<Producto> listarProductos() {
        
        List<Producto> listarproductos=ProductRepo.findAll();
        
        return listarproductos;
        
    }

    @Override
    public String  crearProducto(Producto producto) {
        
        ProductRepo.save(producto);
        
        return "Producto creado";
        
        
    }

    @Override
    public Producto buscarProducto(Long id_producto) {
       
       Producto producto=ProductRepo.findById(id_producto).orElse(null);
       
       return producto;
       
    }

    @Override
    public String  editarproducto(Long id_producto, String nombre,String marca, Double precio, Double stock,List<Venta>venta) {
        
        Producto pro=ProductRepo.findById(id_producto).orElse(null);
        
        Producto nuevoProducto= new Producto();
        nuevoProducto.setCodigo_producto(pro.getCodigo_producto());
        
        if(nombre!=null&& !nombre.isEmpty()){
        nuevoProducto.setNombre(nombre);}
        else{nuevoProducto.setNombre(pro.getNombre());}
        
        if(marca!=null&& !marca.isEmpty()){
        nuevoProducto.setMarca(marca);}
        else{nuevoProducto.setMarca(pro.getMarca());
        }
        if(precio!=null&& !precio.equals("")){
        nuevoProducto.setPrecio(precio);}
        else{nuevoProducto.setPrecio(pro.getPrecio());}
        
        if(stock!=null&& !stock.equals("")){
        nuevoProducto.setStock(stock);}
        else{nuevoProducto.setStock(pro.getStock());
            
        }
        
        nuevoProducto.setVentas(pro.getVentas());
        
        ProductRepo.save(nuevoProducto);
        
        
        
        
        
        
        
        return "Producto Editado";
        
    }

    @Override
    public String borrarproducto(Long id_producto) {
        ProductRepo.deleteById(id_producto);
        
        return "Producto borrado";
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto>faltaStock=new ArrayList();
        
        List<Producto>productos=ProductRepo.findAll();
        
        for(Producto pro:productos){
            
            if(pro.getStock()<=5){
                faltaStock.add(pro);
            }
        }
        
        return faltaStock;
    }
    
    
        
    
}