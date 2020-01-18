package com.ejemplo.spring.facturacion.bean;

import java.io.Serializable;

public class DetalleComprobanteBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer ID;
	private String nombreLibro;
	private Integer cantidadLibro;
	
	
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
	public Integer getCantidadLibro() {
		return cantidadLibro;
	}
	public void setCantidadLibro(Integer cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}
	
}
