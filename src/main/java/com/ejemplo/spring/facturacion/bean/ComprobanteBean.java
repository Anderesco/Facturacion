package com.ejemplo.spring.facturacion.bean;

import java.io.Serializable;

public class ComprobanteBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long ID;
	private Double numeroComprobante;
	private String nombreCliente;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String DNI;
	private String RUC;
	private Double montototal;
	private String estado;
	private String sede;
	
	
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
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

	public Double getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(Double numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public Double getMontototal() {
		return montototal;
	}
	public void setMontototal(Double montototal) {
		this.montototal = montototal;
	}
	@Override
	public String toString() {
		return "ComprobanteBean [ID=" + ID + ", numeroComprobante=" + numeroComprobante + ", nombreCliente="
				+ nombreCliente + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", DNI=" + DNI + ", RUC=" + RUC + ", montototal=" + montototal + ", estado=" + estado + ", sede="
				+ sede + "]";
	}
	
	
}
