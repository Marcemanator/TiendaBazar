
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.DTO.ventaDTO;
import com.Bazar.Bazar.Model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
     public List <Venta> listarVentas();
    
    public Venta crearVenta(List<Long>listaidsproductos,Long clienteId);
    
    public Venta buscarVenta(Long id_venta);
    
    public String editarVenta(Long codigo_venta,LocalDate fecha_venta );
    
    public String borrarventa(Long id_venta);
    
    
    
}