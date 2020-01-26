package com.ejemplo.spring.facturacion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.service.ComprobanteServiceImpl;

@Controller("/")
public class ComprobanteController 
{
	@Autowired
	ComprobanteServiceImpl comprobanteServiceImpl;
	
	@GetMapping("comprobante")
	public String MostrarComprobante(Model modelo)
	{
		ComprobanteBean comprobanteBean = new ComprobanteBean();
		List<ComprobanteBean> listaComprobanteBean = comprobanteServiceImpl.guardarComprobante();		
		/*comprobanteServiceImpl.guardarComprobante().forEach(com -> {
			System.out.println(com.getID());
			
		});*/
		
		modelo.addAttribute("comprobanteBean", listaComprobanteBean);
		
		
		return "Index";
	}
	
}
