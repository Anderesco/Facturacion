package com.ejemplo.spring.facturacion.service;

import java.util.List;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.entity.Comprobante;

public interface ComprobanteService 
{
	public List<ComprobanteBean> guardarComprobante();
	public List<Comprobante> mostrarComprobante();
}
