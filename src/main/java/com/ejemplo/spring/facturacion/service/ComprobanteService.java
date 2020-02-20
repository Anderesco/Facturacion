package com.ejemplo.spring.facturacion.service;

import java.util.List;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.bean.JSONRecibidoBean;
import com.ejemplo.spring.facturacion.entity.Comprobante;

public interface ComprobanteService 
{
	public List<ComprobanteBean> mostrarComprobante(Integer ID);
	public List<ComprobanteBean> mostrarComprobanteTotal();
	public Comprobante guardarComprobante(JSONRecibidoBean comprobanteEnviado);
	public List<ComprobanteBean> actualizarEstadoComprobante(Integer ID);
}
