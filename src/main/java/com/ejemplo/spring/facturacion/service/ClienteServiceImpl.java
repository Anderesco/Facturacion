package com.ejemplo.spring.facturacion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.ClienteBean;
import com.ejemplo.spring.facturacion.dao.ClienteDao;

@Component
public class ClienteServiceImpl implements ClienteService
{
	@Autowired
	ClienteDao clienteDao;
	
	@Override
	public List<ClienteBean> guardarCliente() 
	{
		return clienteDao.mostrarCliente().stream().map(cliente -> {
			ClienteBean clienteBean = new ClienteBean();
			clienteBean.setID(cliente.getIdCliente());
			clienteBean.setNombreCliente(cliente.getNombreCliente());
			clienteBean.setApellidoPaterno(cliente.getApellidoPaternoCliente());
			clienteBean.setApellidoMaterno(cliente.getApellidoMaternoCliente());
			clienteBean.setDNI(cliente.getDniCliente());
			clienteBean.setRUC(cliente.getRucCliente());
			
			return clienteBean;
		}).collect(Collectors.toList());
	}
	
}
