package com.ejemplo.spring.facturacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "detallecomprobante")
public class DetalleComprobante 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idDetalle;
	
	@JoinColumn(name = "IDComprobante")
	@ManyToOne(fetch = FetchType.EAGER)
	private Comprobante comprobante;
	
	@JoinColumn(name = "IDLibro")
	@ManyToOne(fetch = FetchType.EAGER)
	private Libro libro;
	
	@Column(name = "Cantidad")
	private Integer cantidadLibroDetalle;
	

	public DetalleComprobante() {
		super();
	}
	
	public DetalleComprobante(Comprobante comprobante, Libro libro, Integer cantidadLibroDetalle) {
		this.comprobante = comprobante;
		this.libro = libro;
		this.cantidadLibroDetalle = cantidadLibroDetalle;
	}



	public Libro getLibro() {
		return libro;
	}



	public void setLibro(Libro libro) {
		this.libro = libro;
	}



	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Integer getCantidadLibroDetalle() {
		return cantidadLibroDetalle;
	}

	public void setCantidadLibroDetalle(Integer cantidadLibroDetalle) {
		this.cantidadLibroDetalle = cantidadLibroDetalle;
	}

	@Override
	public String toString() {
		return "DetalleComprobante{" +
				"idDetalle=" + idDetalle +
				", comprobante=" + comprobante +
				", libro=" + libro +
				", cantidadLibroDetalle=" + cantidadLibroDetalle +
				'}';
	}
}
