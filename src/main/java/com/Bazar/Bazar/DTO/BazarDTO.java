
package com.Bazar.Bazar.DTO;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter
public class BazarDTO {
    
    private Long codigo_venta;
    private Double total;
    private int cantidadProductos;
    private String nombrecliente;
    private String ApellidoCliente;

    public BazarDTO() {
    }

    public BazarDTO(Long codigo_venta, Double total, int cantidadProductos, String nombrecliente, String ApellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombrecliente = nombrecliente;
        this.ApellidoCliente = ApellidoCliente;
    }
    
    
    
    
    
    
    
    
    
    
}