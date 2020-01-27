package com.ejemplo.spring.facturacion.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	@ManyToOne(cascade = CascadeType.ALL)
	private Comprobante comprobante;
	
	@JoinColumn(name = "IDLibro")
	@ManyToOne(cascade = CascadeType.ALL)
	private Libro libro;
	
	@Column(name = "Cantidad")
	private Integer cantidadLibroDetalle;
	

	public DetalleComprobante() {
		super();
	}
	
	public DetalleComprobante(Integer idDetalle, Comprobante comprobante, Libro libro, Integer cantidadLibroDetalle) {
		super();
		this.idDetalle = idDetalle;
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
	
}
