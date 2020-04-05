package com.ejemplo.spring.facturacion.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.bean.ComprobanteBean;
import com.ejemplo.spring.facturacion.bean.JSONRecibidoBean;
import com.ejemplo.spring.facturacion.dao.ClienteDao;
import com.ejemplo.spring.facturacion.dao.ComprobanteDao;
import com.ejemplo.spring.facturacion.dao.DetalleComprobanteDao;
import com.ejemplo.spring.facturacion.dao.LibroDao;
import com.ejemplo.spring.facturacion.dao.SedeDao;
import com.ejemplo.spring.facturacion.entity.Cliente;
import com.ejemplo.spring.facturacion.entity.Comprobante;
import com.ejemplo.spring.facturacion.entity.DetalleComprobante;
import com.ejemplo.spring.facturacion.entity.Libro;
import com.ejemplo.spring.facturacion.entity.Sede;
import com.ejemplo.spring.facturacion.util.ObtenerJSONURL;

@Component
public class ComprobanteServiceImpl implements ComprobanteService
{
	
	@Autowired
	ComprobanteDao comprobanteDao;
	
	@Autowired
	DetalleComprobanteDao detalleComprobanteDao;
	
	@Autowired
	DetalleComprobanteServiceImpl detalleComprobante;
	
	@Autowired
	JSONRecibidoBean jsonRecibidoBean;
	
	@Autowired
	LibroDao libroDao;
	
	@Autowired
	ClienteDao clienteDao;
	
	@Autowired
	SedeDao sedeDao;
	
	ObtenerJSONURL jsonRecibido = new ObtenerJSONURL();
	
	Date fechaActual = new Date();
	Date fechaEmision = new Date();
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Override
	public List<ComprobanteBean> mostrarComprobante(Integer ID) {	
		return comprobanteDao.mostrarComprobante().stream().filter(comprobante -> comprobante.getIdComprobante() == ID).map(comprobante -> {
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
			comprobanteBean.setDetalleComprobante(detalleComprobante.mostrarDetalle(ID));
			
			return comprobanteBean;
		}).collect(Collectors.toList());
	}
	
	@Override
	public List<ComprobanteBean> mostrarComprobanteTotal() {	
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
	
	@Override
	public Comprobante guardarComprobante(JSONRecibidoBean jsonRecibidoBean)
	{				
		
		Comprobante comprobante = new Comprobante();
		Sede sede = new Sede();
		Cliente cliente = new Cliente();
		
		sede.setNombreSede(jsonRecibidoBean.getSede().getNombreSede());
		sede.setDireccionSede(jsonRecibidoBean.getSede().getDireccionSede());
		sede.setTelefonoSede(jsonRecibidoBean.getSede().getTelefonoSede());
		sedeDao.guardarSede(sede);
		
		cliente.setNombreCliente(jsonRecibidoBean.getCliente().getNombreCliente());
		cliente.setApellidoPaternoCliente(jsonRecibidoBean.getCliente().getApellidoPaternoCliente());
		cliente.setApellidoMaternoCliente(jsonRecibidoBean.getCliente().getApellidoMaternoCliente());
		cliente.setDniCliente(jsonRecibidoBean.getCliente().getDniCliente());
		cliente.setRucCliente(jsonRecibidoBean.getCliente().getRucCliente());
		cliente.setEdad(jsonRecibidoBean.getCliente().getEdad());
		
		clienteDao.guardarCliente(cliente);
		
		comprobante.setEstadoComprobante(jsonRecibidoBean.getEstado());
		comprobante.setNumeroComprobante(Integer.parseInt(String.valueOf(jsonRecibidoBean.getNumeroComprobante())));
		comprobante.setMontoTotal(Float.parseFloat(String.valueOf(jsonRecibidoBean.getMonto())));
		comprobante.setSede(sede);
		comprobante.setCliente(cliente);
		comprobante.setFechaCreacion(fechaActual);
		comprobante.setFechaEmision(null);
		
		comprobante.setIdComprobante(comprobanteDao.guardarComprobante(comprobante));
		
		jsonRecibidoBean.getDetalle().forEach(libro -> {
			Libro libroEntity = new Libro();
			libroEntity.setNombreLibro(libro.getNombreLibro());
			libroEntity.setAnioLibro(libro.getAnio());
			libroEntity.setAutorLibro(libro.getAutor());
			libroEntity.setPrecioLibro(Float.parseFloat(String.valueOf(libro.getPrecioLibro())));
			
			libroEntity.setIdLibro(libroDao.guardarLibro(libroEntity));
			
			DetalleComprobante detalleComprobante = new DetalleComprobante();
			detalleComprobante.setLibro(libroEntity);
			detalleComprobante.setCantidadLibroDetalle( Integer.parseInt(String.valueOf(libro.getCantidadLibro())));
			detalleComprobante.setComprobante(comprobante);
			
			detalleComprobanteDao.guardarDetalleComprobante(detalleComprobante);
		});
		
		return comprobante;
	}

	@Override
	public List<ComprobanteBean> actualizarEstadoComprobante(Integer ID) {
		
		comprobanteDao.actualizarComprobante(ID);
		
		return this.mostrarComprobante(ID);
	}
	
	public Boolean EnviarCorreo(Integer ID)
	{		
		MimeMessage message = mailSender.createMimeMessage();
		String [] correos = {"anderesco94@gmail.com" , "christian.romero2@unmsm.edu.pe"};
		try
		{
			MimeMessageHelper correo = new MimeMessageHelper(message, true);
				
			correo.setTo(correos);
			correo.setSubject("FACTURA PROCESADA");
			correo.setText("Su factura se encuentra procesada, si desea verificar use el siguiente dato para realizar la petición:  \n" + 
						   "ID: " + ID);
				
			/*FileSystemResource archivo = new FileSystemResource("ruta");
			correo.addAttachment(archivo.getFilename(), archivo);*/

		}
		catch (MessagingException e) 
		{
			throw new MailParseException(e);
		}
		
		mailSender.send(message);
		
		System.out.println("Se ha enviado el correo, revise su Inbox");
		
        return true;
	}
}
