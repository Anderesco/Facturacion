package com.ejemplo.spring.facturacion.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

public class ComprobanteBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer ID;
	private Integer numeroComprobante;
	private String nombreCliente;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String DNI;
	private String RUC;
	private String[] libros;
	private Integer[] cantidadlibros;
	private String direccionSede;
	private Float montototal;
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getRUC() {
		return RUC;
	}
	public void setRUC(String rUC) {
		RUC = rUC;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String[] getLibros() {
		return libros;
	}
	public void setLibros(String[] libros) {
		this.libros = libros;
	}
	public Integer[] getCantidadlibros() {
		return cantidadlibros;
	}
	public void setCantidadlibros(Integer[] cantidadlibros) {
		this.cantidadlibros = cantidadlibros;
	}
	public String getDireccionSede() {
		return direccionSede;
	}
	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
	}
	public Integer getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(Integer numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public Float getMontototal() {
		return montototal;
	}
	public void setMontototal(Float montototal) {
		this.montototal = montototal;
	}
	
}
