package com.ejemplo.spring.facturacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.SedeBean;
import com.ejemplo.spring.facturacion.dao.SedeDao;

@Component
public class SedeServiceImpl implements SedeService
{
	@Autowired
	SedeDao sedeDao;
	
	@Override
	public List<SedeBean> guardarSede() 
	{
		return sedeDao.mostrarSede().stream().map(sede -> {
			SedeBean sedeBean = new SedeBean();
			sedeBean.setID(sede.getIdSede());
			sedeBean.setNombreSede(sede.getNombreSede());
			sedeBean.setTelefonoSede(sede.getTelefonoSede());
			sedeBean.setDireccionSede(sede.getDireccionSede());
			
			return sedeBean;
		}).collect(Collectors.toList());
	}
	
}
