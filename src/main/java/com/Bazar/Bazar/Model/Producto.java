
package com.Bazar.Bazar.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
   @ManyToOne
   @JoinColumn(name="codigo_venta")
   @JsonBackReference
   private Venta venta;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double precio, Double stock) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }
    
    
}