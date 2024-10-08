
package com.Bazar.Bazar.Service;

import com.Bazar.Bazar.Model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
     public List <Venta> listarVentas();
    
    public String crearVenta(Venta venta);
    
    public Venta buscarVenta(Long id_venta);
    
    public String editarVenta(Long codigo_venta,LocalDate fecha_venta );
    
    public String borrarventa(Long id_venta);
    
    
    
}