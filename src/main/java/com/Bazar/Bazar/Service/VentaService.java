
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Repository.VentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    
    @Autowired
    VentaRepository VentaRepo;

    @Override
    public List<Venta> listarVentas() {
        List<Venta>listarVentas=VentaRepo.findAll();
        
        return listarVentas;
    }

    @Override
    public String crearVenta(Venta venta) {
        
        VentaRepo.save(venta);
        
        return "Venta creada";
    }

    @Override
    public Venta buscarVenta(Long id_venta) {
        
        Venta venta=VentaRepo.findById(id_venta).orElse(null);
        
        return venta;
        
    }

    @Override
    public String editarVenta(Long codigo_venta, LocalDate fecha_venta) {
        Venta ven=VentaRepo.findById(codigo_venta).orElse(null);
        List<Producto>precioTotalProductos=new ArrayList();
        List<Double>precioProductos=new ArrayList();
        Double precios;
        
        Venta ventaNueva=new Venta();
        
        ventaNueva.setCodigo_venta(ven.getCodigo_venta());
        ventaNueva.setFecha_venta(fecha_venta);
        
        ventaNueva.setListaproductos(ven.getListaproductos());
        for(Producto pro:ven.getListaproductos()){
            precios=pro.getPrecio();
            precioProductos.add(precios);
            }
        Double tot=precioProductos.stream().mapToDouble(Double::doubleValue).sum();
        
        ventaNueva.setTotal(tot);
        ventaNueva.setCliente(ven.getCliente());
        
        return "Venta editada";
        
    }

    @Override
    public String borrarventa(Long id_venta) {
        
        VentaRepo.deleteById(id_venta);
        
        
        return "Venta borrada";
        
       
    }
    
}