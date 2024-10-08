
package com.Bazar.Bazar.Repository;

import com.Bazar.Bazar.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository  extends JpaRepository<Venta,Long> {
    
}