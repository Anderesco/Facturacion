package com.ejemplo.spring.facturacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.DetalleComprobanteBean;
import com.ejemplo.spring.facturacion.bean.JSONRecibidoBean;
import com.ejemplo.spring.facturacion.dao.DetalleComprobanteDao;
import com.ejemplo.spring.facturacion.entity.DetalleComprobante;
import com.ejemplo.spring.facturacion.util.ObtenerJSONURL;

@Component
public class DetalleComprobanteServiceImpl implements DetalleComprobanteService
{
	@Autowired
	DetalleComprobanteDao detalleComprobanteDao;
	
	@Autowired
	LibroServiceImpl libroServiceImpl;
	
	@Autowired
	JSONRecibidoBean jsonRecibidoBean;
	
	ObtenerJSONURL jsonRecibido = new ObtenerJSONURL();
	List<DetalleComprobante> listaDetalleComprobante = new ArrayList<DetalleComprobante>();
	
	@Override
	public List<DetalleComprobanteBean> mostrarDetalle(Integer ID) {
		
		return detalleComprobanteDao.mostrarDetalleComprobante().stream().filter(detalleComprobante -> detalleComprobante.getComprobante().getIdComprobante() == ID).map(detalleComprobante -> {
			DetalleComprobanteBean detalleComprobanteBean = new DetalleComprobanteBean();
			detalleComprobanteBean.setID(detalleComprobante.getIdDetalle());
			detalleComprobanteBean.setCantidadLibro(detalleComprobante.getCantidadLibroDetalle());
			detalleComprobanteBean.setNombreLibro(detalleComprobante.getLibro().getNombreLibro());
			//detalleComprobanteBean.setPrecioUnitario(detalleComprobante.getLibro().getPrecioLibro());
			
			return detalleComprobanteBean;
		}).collect(Collectors.toList());
	}
	
	@Override
	public List<DetalleComprobanteBean> mostrarDetalleTotales() {
		
		return detalleComprobanteDao.mostrarDetalleComprobante().stream().map(detalleComprobante -> {
			DetalleComprobanteBean detalleComprobanteBean = new DetalleComprobanteBean();
			detalleComprobanteBean.setID(detalleComprobante.getIdDetalle());
			detalleComprobanteBean.setCantidadLibro(detalleComprobante.getCantidadLibroDetalle());
			detalleComprobanteBean.setNombreLibro(detalleComprobante.getLibro().getNombreLibro());
			detalleComprobanteBean.setPrecioUnitario(detalleComprobante.getLibro().getPrecioLibro());
			
			return detalleComprobanteBean;
		}).collect(Collectors.toList());
	}
	
	
}
