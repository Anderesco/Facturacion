package com.ejemplo.spring.facturacion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ejemplo.spring.facturacion.entity.Comprobante;

public interface ComprobanteRepository extends CrudRepository<Comprobante, Integer>
{
	@Query("SELECT c.NumeroComprobante, cl.NombreCliente, cl.ApellidoPaterno, cl.ApellidoMaterno, cl.DNI, cl.RUC, li.Nombre, d.Cantidad, "
			+ "s.Nombre, c.MontoTotal"
			+ "FROM comprobante c"
			+ "INNER JOIN cliente cl 			ON cl.ID = c.IDCliente"
			+ "INNER JOIN detallecomprobante d  ON d.ID  = c.IDDetalle"
			+ "INNER JOIN sede s 				ON s.ID  = c.IDSede"
			+ "INNER JOIN libro li				ON li.ID = c.IDLibro"
			+ "WHERE c.ID = :p_ID")
	public List<Object> obtenerComprobante(@Param("p_ID") Integer ID);
}
