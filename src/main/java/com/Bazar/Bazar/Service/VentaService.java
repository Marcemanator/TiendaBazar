
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Repository.ClienteRepository;
import com.Bazar.Bazar.Repository.ProductoRepository;
import com.Bazar.Bazar.Repository.VentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class VentaService implements IVentaService{
    
    
    @Autowired
    VentaRepository VentaRepo;
    @Autowired
    ClienteRepository CliRepo;
    
    @Autowired
    ProductoRepository ProRep;

    @Override
    public List<Venta> listarVentas() {
        List<Venta>listarVentas=VentaRepo.findAll();
        
        return listarVentas;
    }

    @Override
    public String crearVenta(@RequestBody Venta venta) {
        List<Double>dineroVentas=new ArrayList();
        List<Long>idprod=new ArrayList();
        
        List<Producto>Productos=new ArrayList();
        for(Producto produ :venta.getListaproductos()){
            Long pd=produ.getCodigo_producto();
            idprod.add(pd);
            }
            
                  
       
        Double PrecioVenta;
        Double Totales;
        
        
        LocalDate ld=LocalDate.now();
        Venta ven=new Venta();
        for(Producto pro:venta.getListaproductos()){
            PrecioVenta=pro.getPrecio();
            dineroVentas.add(PrecioVenta);
        }
        Totales=dineroVentas.stream().mapToDouble(Double::doubleValue).sum();
       
        
        ven.setCodigo_venta(venta.getCodigo_venta());
        ven.setFecha_venta(ld);
        ven.setTotal(Totales);
        ven.setListaproductos(venta.getListaproductos());
        
        ven.setCliente(venta.getCliente());
        
        
        VentaRepo.save(ven);
        

            return "venta creada";
        
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