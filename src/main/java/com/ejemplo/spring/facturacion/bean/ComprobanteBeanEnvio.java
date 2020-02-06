package com.ejemplo.spring.facturacion.bean;

public class ComprobanteBeanEnvio 
{
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
	
	
	
	public ComprobanteBeanEnvio(Long iD, Double numeroComprobante, String nombreCliente, String apellidoPaterno,
			String apellidoMaterno, String dNI, String rUC, Double montototal, String estado, String sede) {
		this.ID = iD;
		this.numeroComprobante = numeroComprobante;
		this.nombreCliente = nombreCliente;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		DNI = dNI;
		RUC = rUC;
		this.montototal = montototal;
		this.estado = estado;
		this.sede = sede;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Double getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(Double numeroComprobante) {
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
	public Double getMontototal() {
		return montototal;
	}
	public void setMontototal(Double montototal) {
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
				+ sede + "]";
	}
	
	
}
