package com.ejemplo.spring.facturacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.LibroBean;
import com.ejemplo.spring.facturacion.dao.LibroDao;

@Component
public class LibroServiceImpl implements LibroService
{
	@Autowired
	LibroDao libroDao;
	
	@Override
	public List<LibroBean> guardarLibro() {
		return libroDao.mostrarLibro().stream().map(libro -> {
			LibroBean libroBean = new LibroBean();
			libroBean.setID(libro.getIdLibro());
			libroBean.setNombreLibro(libro.getNombreLibro());
			libroBean.setPrecioLibro(libro.getPrecioLibro());
			
			return libroBean;
		}).collect(Collectors.toList());
	}

}
