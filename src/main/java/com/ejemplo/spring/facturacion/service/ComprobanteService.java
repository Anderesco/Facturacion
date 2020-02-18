package com.ejemplo.spring.facturacion.service;

import java.util.List;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;

public interface ComprobanteService 
{
	public List<ComprobanteBean> mostrarComprobante(Integer ID);
	public List<ComprobanteBean> mostrarComprobanteTotal();
}
