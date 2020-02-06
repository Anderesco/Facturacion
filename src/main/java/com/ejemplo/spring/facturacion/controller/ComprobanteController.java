package com.ejemplo.spring.facturacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.bean.ComprobanteBeanEnvio;
import com.ejemplo.spring.facturacion.service.ClienteServiceImpl;
import com.ejemplo.spring.facturacion.service.ComprobanteServiceImpl;
import com.ejemplo.spring.facturacion.service.DetalleComprobanteServiceImpl;
import com.ejemplo.spring.facturacion.service.SedeServiceImpl;

@Controller("/")
public class ComprobanteController 
{
	@Autowired
	ComprobanteServiceImpl comprobanteServiceImpl;
	
	@Autowired
	ClienteServiceImpl clienteServiceImpl;
	
	@Autowired
	DetalleComprobanteServiceImpl detalleComprobanteServiceImpl;
	
	@Autowired
	SedeServiceImpl sedeServiceImpl;
	
	@GetMapping("comprobante")
	public String MostrarComprobante(Model modelo) throws IOException, JSONException
	{
		List<ComprobanteBean> listaComprobanteBean = comprobanteServiceImpl.mostrarComprobante();
		comprobanteServiceImpl.mostrarComprobante().forEach(com -> {
			System.out.println("ID: " + com.getID());
			System.out.println("Numero Comprobante: " + com.getNumeroComprobante());
			System.out.println("NombreCliente: " + com.getNombreCliente());
			System.out.println("Apellido Paterno: " + com.getApellidoPaterno());
			System.out.println("Apellido Materno: " + com.getApellidoMaterno());
			System.out.println("DNI: " + com.getDNI());
			System.out.println("RUC: " + com.getRUC());
			System.out.println("Monto total: " + com.getMontototal());
			System.out.println("Estado: " + com.getEstado());
			System.out.println("Sede:" + com.getSede());
		}); 
		
		/*clienteServiceImpl.guardarCliente().forEach(cliente -> {
			System.out.println("Nombre : " + cliente.getNombreCliente());
			System.out.println("Apellido Pat. : " + cliente.getApellidoPaterno());
			System.out.println("Apellido Mat. :" + cliente.getApellidoMaterno());
			System.out.println("DNI : " + cliente.getDNI());
			System.out.println("RUC : " + cliente.getRUC());
		});
		
		detalleComprobanteServiceImpl.guardarDetalle().forEach(detalle -> {
			System.out.println("ID: " + detalle.getID());
			System.out.println("Cantidad de Libros: " + detalle.getCantidadLibro());
			System.out.println("Nombre Libro:" + detalle.getNombreLibro());
		});*/
		
		/*sedeServiceImpl.guardarSede().forEach(sede -> {
			System.out.println("ID" + sede.getID());
			System.out.println("Nombre Sede: " + sede.getNombreSede());
			System.out.println("Direccion: " + sede.getDireccionSede());
			System.out.println("Telefono: " + sede.getTelefonoSede());
		});
		*/
		
		modelo.addAttribute("comprobanteBean", listaComprobanteBean);
		
		
		return "Index";
	}
	
	@ResponseBody
	@RequestMapping("prueba-json")				   
	public List<ComprobanteBean> listarComprobantes() {
		
		return comprobanteServiceImpl.mostrarComprobante();
	}
	
	
	@ResponseBody
	@RequestMapping("prueba-json-post")
	public List<ComprobanteBean> ingresarComprobantes (@RequestBody ComprobanteBean comprobante)
	{
		System.out.println(comprobante.toString());
		return comprobanteServiceImpl.mostrarComprobante();
	}
	
	@ResponseBody
	@RequestMapping("prueba-json-envio")				   
	public List<ComprobanteBeanEnvio> listarComprobantesEnvio() {
		ComprobanteBeanEnvio envio = new ComprobanteBeanEnvio((long)1, (double)1000, "Carol", "Martinez", "Corzo", "70057321", null, 2000.00 , "Pendiente", "SJL");
		List<ComprobanteBeanEnvio> comprobanteEnvio = new ArrayList<ComprobanteBeanEnvio>();
		comprobanteEnvio.add(envio);
		System.out.println("Lista: "+ comprobanteEnvio.toString());
		return comprobanteEnvio;
	}
	
}
