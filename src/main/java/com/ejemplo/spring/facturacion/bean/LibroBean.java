package com.ejemplo.spring.facturacion.bean;

import java.io.Serializable;

public class LibroBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long ID;
	private String nombreLibro;
	private Double precioLibro;
	
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public Double getPrecioLibro() {
		return precioLibro;
	}
	public void setPrecioLibro(Double precioLibro) {
		this.precioLibro = precioLibro;
	}	
	
}
