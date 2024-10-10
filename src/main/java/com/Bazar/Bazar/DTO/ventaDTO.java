
package com.Bazar.Bazar.DTO;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;





@Getter @Setter
public class ventaDTO {
    
    Long codigo_venta;
    LocalDate fecha_venta;
    Double total;
    
    List<Long> codigo_producto;
    
    Long id_cliente;

    public ventaDTO() {
    }

    public ventaDTO(Long codigo_venta, LocalDate fecha_venta, Double total, List<Long> codigo_producto, Long id_cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.codigo_producto = codigo_producto;
        this.id_cliente = id_cliente;
    }

  
    
   
    
    
    
    
}
