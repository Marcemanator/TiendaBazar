package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.DTO.ventaDTO;
import com.Bazar.Bazar.Model.Cliente;
import com.Bazar.Bazar.Model.Producto;
import com.Bazar.Bazar.Model.Venta;
import com.Bazar.Bazar.Repository.ClienteRepository;
import com.Bazar.Bazar.Repository.ProductoRepository;
import com.Bazar.Bazar.Repository.VentaRepository;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class VentaService implements IVentaService {

    @Autowired
    VentaRepository VentaRepo;
    
    @Autowired
    ClienteRepository CliRepo;

    @Autowired
    ProductoRepository ProRep;

    @Override
    public List<Venta> listarVentas() {
        List<Venta> listarVentas = VentaRepo.findAll();

        return listarVentas;
    }

   

    @Override
    public Venta buscarVenta(Long id_venta) {

        Venta venta = VentaRepo.findById(id_venta).orElseThrow(() -> new RuntimeException("venta no encontrada"));

        return venta;

    }
       @Override
    public Venta crearVenta(List<Long> listaidsproductos, Long clienteId){
        LocalDate ld=LocalDate.now();
        List<Producto>productos=ProRep.findAllById(listaidsproductos);
        List<Producto>listaP=new ArrayList();
        Cliente cliente=CliRepo.findById(clienteId).orElseThrow(()->new RuntimeException("Cliente no encontrado"));
        
        for(Producto pro:productos){
            if(pro.getStock()<=0){
                throw new RuntimeException("No hay suficiente Stock de esste producto");
           
           }
}
        Venta venta= new Venta();
        venta.setCliente(cliente);
        venta.setListaproductos(productos);
        
        venta.setFecha_venta(ld);
     
        Double Totales=productos.stream().mapToDouble(Producto::getPrecio).sum();
        venta.setTotal(Totales);
        
        for(Producto producto:productos){
            producto.setStock(producto.getStock()-1);
            ProRep.save(producto);
        }
        
        return VentaRepo.save(venta);
        
    }


    @Override
    public String editarVenta(Long codigo_venta, String fecha_venta,List<Long>idsproductos) {
        Venta ven = VentaRepo.findById(codigo_venta).orElse(null);
        List<Producto> TotalProductos = new ArrayList();
        List<Producto>productos=ProRep.findAllById(idsproductos);
        
        List<Double> precioProductos = new ArrayList();
        Double precios;
        
        Venta ventaNueva = new Venta();
       
        DateTimeFormatter dtf=  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha=LocalDate.parse(fecha_venta, dtf);
        
        ventaNueva.setCodigo_venta(ven.getCodigo_venta());
        ventaNueva.setFecha_venta(fecha);

        
        for (Producto pro : productos) {
            precios = pro.getPrecio();
            precioProductos.add(precios);
           
            TotalProductos.add(pro);
        }
        Double tot = precioProductos.stream().mapToDouble(Double::doubleValue).sum();
        ventaNueva.setTotal(tot);
        ventaNueva.setCliente(ven.getCliente());
        
        ventaNueva.setListaproductos(TotalProductos);
        
        VentaRepo.save(ventaNueva);

        return "Venta editada";

    }

    @Override
    public String borrarventa(Long id_venta) {

        VentaRepo.deleteById(id_venta);

        return "Venta borrada";

    }
}
 

