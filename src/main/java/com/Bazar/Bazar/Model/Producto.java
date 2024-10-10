
package com.Bazar.Bazar.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Producto {
    
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE)
   private Long codigo_producto;
   private String nombre;
   private String marca;
   private Double precio;
   private Double stock;
   @ManyToMany(mappedBy="listaproductos")
   private List<Venta> ventas;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double precio, Double stock, List<Venta> ventas) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.ventas = ventas;
    }

   
    
}