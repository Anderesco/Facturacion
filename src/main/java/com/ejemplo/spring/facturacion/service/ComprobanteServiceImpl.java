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

	@Override
	public List<ComprobanteBean> guardarComprobante() {	
		return comprobanteDao.mostrarComprobante().stream().map(comprobante -> {
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
			
			return comprobanteBean;
		}).collect(Collectors.toList());
	}
}
