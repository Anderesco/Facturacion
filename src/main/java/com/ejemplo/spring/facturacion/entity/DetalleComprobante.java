package com.ejemplo.spring.facturacion.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detallecomprobante")
public class DetalleComprobante 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idDetalle;
	
	//@JoinColumn
	//@OneToOne(cascade = CascadeType.ALL)
	//Comprobante comprobante;
	
	//@JoinColumn
	//@OneToMany(cascade = CascadeType.ALL)
	//Libro libro;
	
	@Column(name = "NombreLibro")
	private String nombreLibro;
	
	@Column(name = "Cantidad")
	private Integer cantidadLibroDetalle;
	

	public DetalleComprobante() {
		super();
	}

	public DetalleComprobante(Integer idDetalle, /*Comprobante comprobante, Libro libro,*/ String nombreLibro,
			Integer cantidadLibroDetalle) {
		super();
		this.idDetalle = idDetalle;
		//this.comprobante = comprobante;
		//this.libro = libro;
		this.nombreLibro = nombreLibro;
		this.cantidadLibroDetalle = cantidadLibroDetalle;
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	/*public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}*/

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public Integer getCantidadLibroDetalle() {
		return cantidadLibroDetalle;
	}

	public void setCantidadLibroDetalle(Integer cantidadLibroDetalle) {
		this.cantidadLibroDetalle = cantidadLibroDetalle;
	}

	/*public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}*/
	
}
