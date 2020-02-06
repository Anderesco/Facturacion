package com.ejemplo.spring.facturacion.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.json.JsonObject;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.dao.ComprobanteDao;
import com.ejemplo.spring.facturacion.entity.Cliente;
import com.ejemplo.spring.facturacion.entity.Comprobante;
import com.ejemplo.spring.facturacion.entity.DetalleComprobante;
import com.ejemplo.spring.facturacion.entity.Sede;
import com.google.gson.Gson;

@Component
public class ComprobanteServiceImpl implements ComprobanteService
{
	
	@Autowired
	ComprobanteDao comprobanteDao;
	
	@Override
	public List<ComprobanteBean> mostrarComprobante() {	
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
	
	/*public void guardarComprobante(Integer numeroComprobante, String estadoComprobante, Float montoTotal)
	{
		//Integer idComprobante, Integer numeroComprobante, Cliente cliente, Sede sede, List<DetalleComprobante> detallecomprobante, Date fechaCreacion, String estadoComprobante, Date fechaEmision, Float montoTotal
		//Comprobante comprobante = new Comprobante(numeroComprobante, null, null, null, null, estadoComprobante, null, montoTotal);
		
		//System.out.println(comprobante.toString());
		
		comprobanteDao.guardarComprobante(comprobante);
	}*/
}
