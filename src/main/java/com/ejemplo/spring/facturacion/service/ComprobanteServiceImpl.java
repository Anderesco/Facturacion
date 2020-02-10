package com.ejemplo.spring.facturacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.dao.ComprobanteDao;

@Component
public class ComprobanteServiceImpl implements ComprobanteService
{
	
	@Autowired
	ComprobanteDao comprobanteDao;
	
	@Autowired
	DetalleComprobanteServiceImpl detalleComprobante;
	
	@Override
	public List<ComprobanteBean> mostrarComprobante(Integer ID) {	
		return comprobanteDao.mostrarComprobante().stream().filter(comprobante -> comprobante.getIdComprobante() == ID).map(comprobante -> {
			ComprobanteBean comprobanteBean = new ComprobanteBean();
			comprobanteBean.setID(comprobante.getIdComprobante());
			comprobanteBean.setNumeroComprobante(comprobante.getNumeroComprobante());
			comprobanteBean.setNombreCliente(comprobante.getCliente().getNombreCliente());
			comprobanteBean.setApellidoPaterno(comprobante.getCliente().getApellidoPaternoCliente());
			comprobanteBean.setApellidoMaterno(comprobante.getCliente().getApellidoMaternoCliente());
			comprobanteBean.setDNI(comprobante.getCliente().getDniCliente());
			comprobanteBean.setRUC(comprobante.getCliente().getRucCliente());
			comprobanteBean.setMontototal(comprobante.getMontoTotal());
			comprobanteBean.setEstado(comprobante.getEstadoComprobante());
			comprobanteBean.setSede(comprobante.getSede().getNombreSede());
			comprobanteBean.setDetalleComprobante(detalleComprobante.mostrarDetalle(ID));
			
			return comprobanteBean;
		}).collect(Collectors.toList());
	}
	
	/*public void guardarComprobante(Integer numeroComprobante, String estadoComprobante, Float montoTotal)
	{
		//Integer idComprobante, Integer numeroComprobante, Cliente cliente, Sede sede, List<DetalleComprobante> detallecomprobante, Date fechaCreacion, String estadoComprobante, Date fechaEmision, Float montoTotal
		//Comprobante comprobante = new Comprobante(numeroComprobante, null, null, null, null, estadoComprobante, null, montoTotal);
		
		//System.out.println(comprobante.toString());
		
		comprobanteDao.guardarComprobante(comprobante);
	}*/
}
