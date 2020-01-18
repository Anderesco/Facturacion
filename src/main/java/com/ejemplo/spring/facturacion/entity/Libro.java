package com.ejemplo.spring.facturacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
