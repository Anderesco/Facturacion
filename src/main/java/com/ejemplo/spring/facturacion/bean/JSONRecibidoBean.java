package com.ejemplo.spring.facturacion.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ejemplo.spring.facturacion.entity.Cliente;
import com.ejemplo.spring.facturacion.entity.Sede;


@Component
public class JSONRecibidoBean 
{
	private Cliente cliente;
	private Sede sede;
	private Float monto;
	private String estado;
	private Integer numeroComprobante;
	private List<JSONRecibidoDetalleBean> detalle;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<JSONRecibidoDetalleBean> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<JSONRecibidoDetalleBean> detalle) {
		this.detalle = detalle;
	}
	public Integer getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(Integer numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	
	
	@Override
	public String toString() {
		return "JSONRecibidoBean [cliente=" + cliente + ", sede=" + sede + ", monto=" + monto + ", estado=" + estado
				+ ", numeroComprobante=" + numeroComprobante + ", detalle=" + detalle + "]";
	}
	
}
