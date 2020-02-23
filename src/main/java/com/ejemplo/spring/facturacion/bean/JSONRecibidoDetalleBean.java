package com.ejemplo.spring.facturacion.bean;

import org.springframework.stereotype.Component;

@Component
public class JSONRecibidoDetalleBean 
{
	private String nombreLibro;
	private Long cantidadLibro;
	private Double precioLibro;
	private Integer anio;
	private String autor;
	
	
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
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	@Override
	public String toString() {
		return "JSONRecibidoDetalleBean [nombreLibro=" + nombreLibro + ", cantidadLibro=" + cantidadLibro
				+ ", precioLibro=" + precioLibro + ", anio=" + anio + ", autor=" + autor + "]";
	}
	
	
}
