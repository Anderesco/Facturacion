package com.ejemplo.spring.facturacion.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "comprobante")
public class Comprobante 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idComprobante;
	
	@Column(name = "NumeroComprobante")
	private Double numeroComprobante;
	
	@JoinColumn(name = "IDCliente")
	@ManyToOne(cascade=CascadeType.ALL)
	private Cliente cliente;
	
	@JoinColumn(name = "IDSede")
	@ManyToOne(cascade = CascadeType.ALL)
	private Sede sede;
	
	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<DetalleComprobante> detallecomprobante;
	
	@Column(name = "FechaCreacion")
	private Date fechaCreacion;
	
	@Column(name = "Estado")
	private String estadoComprobante;
	
	@Column(name = "FechaEmision")
	private Date fechaEmision;
	
	@Column(name = "MontoTotal")
	private Double montoTotal;

	
	public Comprobante() {
		super();
	}

	
	public Comprobante(Double numeroComprobante, Cliente cliente, Sede sede,
			List<DetalleComprobante> detallecomprobante, Date fechaCreacion, String estadoComprobante,
			Date fechaEmision, Double montoTotal) {
		this.numeroComprobante = numeroComprobante;
		this.cliente = cliente;
		this.sede = sede;
		this.detallecomprobante = detallecomprobante;
		this.fechaCreacion = fechaCreacion;
		this.estadoComprobante = estadoComprobante;
		this.fechaEmision = fechaEmision;
		this.montoTotal = montoTotal;
	}

	public List<DetalleComprobante> getDetallecomprobante() {
		return detallecomprobante;
	}

	public void setDetallecomprobante(List<DetalleComprobante> detallecomprobante) {
		this.detallecomprobante = detallecomprobante;
	}

	public Long getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(Long idComprobante) {
		this.idComprobante = idComprobante;
	}

	public Double getNumeroComprobante() {
		return numeroComprobante;
	}

	public void setNumeroComprobante(Double numeroComprobante2) {
		this.numeroComprobante = numeroComprobante2;
	}

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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstadoComprobante() {
		return estadoComprobante;
	}

	public void setEstadoComprobante(String estadoComprobante) {
		this.estadoComprobante = estadoComprobante;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	@Override
	public String toString() {
		return "Comprobante{" +
				"idComprobante=" + idComprobante +
				", numeroComprobante=" + numeroComprobante +
				", cliente=" + cliente +
				", sede=" + sede +
				", detallecomprobante=" + detallecomprobante +
				", fechaCreacion=" + fechaCreacion +
				", estadoComprobante='" + estadoComprobante + '\'' +
				", fechaEmision=" + fechaEmision +
				", montoTotal=" + montoTotal +
				'}';
	}
}
