package com.ejemplo.spring.facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplo.spring.facturacion.service.ComprobanteServiceImpl;

@Controller("/")
public class ComprobanteController 
{
	@Autowired
	ComprobanteServiceImpl comprobanteServiceImpl;
	
	@GetMapping("comprobante")
	public String MostrarComprobante()
	{
		comprobanteServiceImpl.guardarComprobante().forEach(com -> {
			System.out.println(com.getID());
		});;
		
		return "Index";
	}
}
