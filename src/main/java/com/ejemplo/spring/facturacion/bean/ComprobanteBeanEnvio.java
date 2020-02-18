package com.ejemplo.spring.facturacion.bean;

import java.util.List;


public class ComprobanteBeanEnvio 
{
	private Integer ID;
	private Integer numeroComprobante;
	private String nombreCliente;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String DNI;
	private String RUC;
	private Float montototal;
	private String estado;
	private String sede;
	private List<DetalleComprobanteBean> detalle;
	
	
	
	public ComprobanteBeanEnvio(Integer iD, Integer numeroComprobante, String nombreCliente, String apellidoPaterno,
			String apellidoMaterno, String dNI, String rUC, Float montototal, String estado, String sede,
			List<DetalleComprobanteBean> detalle) {
		super();
		ID = iD;
		this.numeroComprobante = numeroComprobante;
		this.nombreCliente = nombreCliente;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		DNI = dNI;
		RUC = rUC;
		this.montototal = montototal;
		this.estado = estado;
		this.sede = sede;
		this.detalle = detalle;
	}
	
	public List<DetalleComprobanteBean> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleComprobanteBean> detalle) {
		this.detalle = detalle;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(Integer numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
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
	public Float getMontototal() {
		return montototal;
	}
	public void setMontototal(Float montototal) {
		this.montototal = montototal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}

	@Override
	public String toString() {
		return "ComprobanteBeanEnvio [ID=" + ID + ", numeroComprobante=" + numeroComprobante + ", nombreCliente="
				+ nombreCliente + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
				+ ", DNI=" + DNI + ", RUC=" + RUC + ", montototal=" + montototal + ", estado=" + estado + ", sede="
				+ sede + ", detalle=" + detalle + "]";
	}

	

	
	
	
}
