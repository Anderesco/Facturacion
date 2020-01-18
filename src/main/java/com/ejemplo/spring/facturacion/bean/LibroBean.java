package com.ejemplo.spring.facturacion.bean;

import java.io.Serializable;

public class LibroBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer ID;
	private String nombreLibro;
	private Float precioLibro;
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public Float getPrecioLibro() {
		return precioLibro;
	}
	public void setPrecioLibro(Float precioLibro) {
		this.precioLibro = precioLibro;
	}	
	
}
