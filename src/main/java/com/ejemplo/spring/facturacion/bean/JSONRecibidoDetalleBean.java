package com.ejemplo.spring.facturacion.bean;

import org.springframework.stereotype.Component;

@Component
public class JSONRecibidoDetalleBean 
{
	private String nombreLibro;
	private Long cantidadLibro;
	private Double precioLibro;
	
	
	
	
	public JSONRecibidoDetalleBean() {
		super();
	}
	public JSONRecibidoDetalleBean(String nombreLibro, Long cantidadLibro, Double precioLibro) {
		super();
		this.nombreLibro = nombreLibro;
		this.cantidadLibro = cantidadLibro;
		this.precioLibro = precioLibro;
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public Long getCantidadLibro() {
		return cantidadLibro;
	}
	public void setCantidadLibro(Long cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}
	public Double getPrecioLibro() {
		return precioLibro;
	}
	public void setPrecioLibro(Double precioLibro) {
		this.precioLibro = precioLibro;
	}
	@Override
	public String toString() {
		return "JSONRecibidoDetalleBean [nombreLibro=" + nombreLibro + ", cantidadLibro=" + cantidadLibro
				+ ", precioLibro=" + precioLibro + "]";
	}
	
	
}
