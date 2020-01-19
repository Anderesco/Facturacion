package com.ejemplo.spring.facturacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.dao.ComprobanteDao;
import com.ejemplo.spring.facturacion.entity.Comprobante;

@Component
public class ComprobanteServiceImpl implements ComprobanteService
{
	static List<Comprobante> listaComprobante = new ArrayList<Comprobante>();
	
	@Autowired
	Comprobante comprobante;
	
	@Autowired
	ComprobanteDao comprobanteDao;
	
	@Override
	public void mostrarComprobante() 
	{
		
		listaComprobante = comprobanteDao.mostrarComprobante();
	}

}
