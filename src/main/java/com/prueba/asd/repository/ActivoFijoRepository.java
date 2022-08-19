package com.prueba.asd.repository;

import com.prueba.asd.entity.ActivoFijo;
import com.prueba.asd.entity.TipoActivoFijo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Geovanny Mantilla
 */

public interface ActivoFijoRepository extends JpaRepository<ActivoFijo, Long> {

   List<ActivoFijo> findByTipoActivoFijo(TipoActivoFijo tipoActivoFijo);

   ActivoFijo findBySerial(String serial);

   List<ActivoFijo> findByFechaCompra(Date fechaCompra);
}
