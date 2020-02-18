package com.ejemplo.spring.facturacion.bean;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class JSONRecibidoBean 
{
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String DNI;
	private String RUC;
	private Double monto;
	private String estado;
	private String sede;
	private Long numeroComprobante;
	private List<JSONRecibidoDetalleBean> detalle;
	
	
	
	public List<JSONRecibidoDetalleBean> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<JSONRecibidoDetalleBean> detalle) {
		this.detalle = detalle;
	}
	public Long getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(Long numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
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
		return "JSONRecibidoBean [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", DNI=" + DNI + ", RUC=" + RUC + ", monto=" + monto + ", estado=" + estado
				+ ", sede=" + sede + ", numeroComprobante=" + numeroComprobante + ", detalle=" + detalle + "]";
	}

	
	
}
