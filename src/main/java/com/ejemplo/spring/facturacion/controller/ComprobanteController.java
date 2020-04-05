package com.ejemplo.spring.facturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.bean.JSONRecibidoBean;
import com.ejemplo.spring.facturacion.service.ClienteServiceImpl;
import com.ejemplo.spring.facturacion.service.ComprobanteServiceImpl;
import com.ejemplo.spring.facturacion.service.DetalleComprobanteServiceImpl;
import com.ejemplo.spring.facturacion.util.ObtenerJSONURL;

@Controller("/")
public class ComprobanteController 
{
	@Autowired
	ComprobanteServiceImpl comprobanteServiceImpl;
	
	@Autowired
	ClienteServiceImpl clienteServiceImpl;
	
	@Autowired
	DetalleComprobanteServiceImpl detalleComprobanteServiceImpl;
	
	
	ObtenerJSONURL obtener = new ObtenerJSONURL();
	
	//Vista
	/*@GetMapping("comprobante")
	public String MostrarComprobante(Model modelo) throws IOException, JSONException
	{
		List<ComprobanteBean> listaComprobanteBean = comprobanteServiceImpl.mostrarComprobanteTotal();
		comprobanteServiceImpl.mostrarComprobanteTotal().forEach(com -> {
			com.toString();
		}); 
		
		modelo.addAttribute("comprobanteBean", listaComprobanteBean);

		return "Index";
	}*/
	
	//GET
	@ResponseBody
	@RequestMapping("/comprobante/{ID}")				   
	public List<ComprobanteBean> listarComprobantesPorUno(Model modelo, @PathVariable Integer ID) 
	{
		modelo.addAttribute("MostrarJSon", comprobanteServiceImpl.mostrarComprobante(ID));
		
		return comprobanteServiceImpl.mostrarComprobante(ID);
	}
	
	//GET
	@ResponseBody
	@RequestMapping("comprobantesTotales")				   
	public List<ComprobanteBean> listarComprobantesPorUno(Model modelo) 
	{		
		modelo.addAttribute("MostrarJSon", comprobanteServiceImpl.mostrarComprobanteTotal());
		
		return comprobanteServiceImpl.mostrarComprobanteTotal();
	}
	
	//POST
	@ResponseBody
	@RequestMapping("guardarComprobante")
	public JSONRecibidoBean ingresarComprobantes (@RequestBody JSONRecibidoBean comprobanteEnviado)
	{
		comprobanteServiceImpl.guardarComprobante(comprobanteEnviado);
		
		return comprobanteEnviado;
	}
	
	//PUT
	@ResponseBody
	@RequestMapping("actualizarComprobante/{ID}")
	public List<ComprobanteBean> actualizarComprobante(@PathVariable Integer ID)
	{
		return comprobanteServiceImpl.actualizarEstadoComprobante(ID);	
	}
	
	//GET
	@ResponseBody
	@RequestMapping("enviarComprobante/{ID}")
	public boolean enviarComprobante(@PathVariable Integer ID)
	{
		return comprobanteServiceImpl.EnviarCorreo(ID);
	}
	
	/*@ResponseBody
	@RequestMapping("prueba-json-envio")				   
	public List<ComprobanteBeanEnvio> listarComprobantesEnvio() 
	{
		DetalleComprobanteBean detalle1 = new DetalleComprobanteBean("La Catita", 2, (float) 20.00);
		DetalleComprobanteBean detalle2 = new DetalleComprobanteBean("Ana Frank", 1, (float) 25.50);
		DetalleComprobanteBean detalle3 = new DetalleComprobanteBean("Koi to Uso", 3, (float) 30.50);
		List<DetalleComprobanteBean> listaDetalle = new ArrayList<DetalleComprobanteBean>();
		
		listaDetalle.add(detalle1);
		listaDetalle.add(detalle2);
		listaDetalle.add(detalle3);
		
		ComprobanteBeanEnvio envio = new ComprobanteBeanEnvio(1, 1000, "Carol", "Martinez", "Corzo", "70057321", null, (float)2000.00 , "Pendiente", "SJL", listaDetalle);
		List<ComprobanteBeanEnvio> comprobanteEnvio = new ArrayList<ComprobanteBeanEnvio>();
		comprobanteEnvio.add(envio);
		System.out.println("Lista: "+ comprobanteEnvio.toString());
		
		return comprobanteEnvio;
	}
	
	@ResponseBody
	@RequestMapping("jsonURL")
	public JSONRecibidoBean obtenerJsonRecibido ()
	{
		ObtenerJSONURL obtener = new ObtenerJSONURL();
		return obtener.ObtenerJSON();
	}*/
	
}
