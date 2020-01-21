package com.ejemplo.spring.facturacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.dao.ComprobanteDao;
import com.ejemplo.spring.facturacion.entity.Comprobante;

@Component
public class ComprobanteServiceImpl implements ComprobanteService
{
	static List<Comprobante> listaComprobante = new ArrayList<Comprobante>();
	
	@Autowired
	ComprobanteDao comprobanteDao;
	
	@Override
	public List<Comprobante> mostrarComprobante() 
	{
		listaComprobante = comprobanteDao.mostrarComprobante();
		listaComprobante.forEach(s -> System.out.println(s.getNumeroComprobante()));
		
		return listaComprobante;
	}

	@Override
	public List<ComprobanteBean> guardarComprobante() {	
		return comprobanteDao.mostrarComprobante().stream().map(comprobante -> {
			ComprobanteBean comprobanteBean = new ComprobanteBean();
			comprobanteBean.setID(comprobante.getIdComprobante());
			comprobanteBean.setNumeroComprobante(comprobante.getNumeroComprobante());
			return comprobanteBean;
		}).collect(Collectors.toList());
	}
	
	public List<ComprobanteBean> mostrarComprobanteBean()
	{
		List<ComprobanteBean> listaComprobante2 = this.guardarComprobante();
		listaComprobante2.forEach(s -> 
		{
			System.out.println("ID: " + s.getID());
			System.out.println("Numero Comprobante: " + s.getNumeroComprobante());
		});
		
		return listaComprobante2;
	}
}
