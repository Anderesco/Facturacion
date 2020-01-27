package com.ejemplo.spring.facturacion.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idLibro;
	
	@Column(name = "Nombre")
	private String nombreLibro;
	
	@Column(name = "PrecioUnitario")
	private Float precioLibro;
	
	@Column(name = "Autor")
	private String autorLibro;
	
	@Column(name = "Anio")
	private Integer anioLibro;
	
	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<DetalleComprobante> detalleComprobante;

	
	public Libro() {
		super();
	}
	

	public Libro(Integer idLibro, String nombreLibro, Float precioLibro, String autorLibro, Integer anioLibro,
			List<DetalleComprobante> detalleComprobante) {
		super();
		this.idLibro = idLibro;
		this.nombreLibro = nombreLibro;
		this.precioLibro = precioLibro;
		this.autorLibro = autorLibro;
		this.anioLibro = anioLibro;
		this.detalleComprobante = detalleComprobante;
	}


	public List<DetalleComprobante> getDetalleComprobante() {
		return detalleComprobante;
	}


	public void setDetalleComprobante(List<DetalleComprobante> detalleComprobante) {
		this.detalleComprobante = detalleComprobante;
	}


	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public Float getPrecioLibro() {
		return precioLibro;
	}

	public void setPrecioLibro(Float precioLibro) {
		this.precioLibro = precioLibro;
	}

	public String getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}

	public Integer getAnioLibro() {
		return anioLibro;
	}

	public void setAnioLibro(Integer anioLibro) {
		this.anioLibro = anioLibro;
	}

}
	
	
