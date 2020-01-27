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
@Table(name = "cliente")
public class Cliente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idCliente;
	
	@Column(name = "Nombre")
	private String nombreCliente;
	
	@Column(name = "ApellidoPaterno")
	private String apellidoPaternoCliente;
	
	@Column(name = "ApellidoMaterno")
	private String apellidoMaternoCliente;
	
	@Column(name = "DNI")
	private String dniCliente;
	
	@Column(name = "RUC")
	private String rucCliente;
	
	@Column(name = "Edad")
	private Integer edad;
	
	@Column(name = "Celular")
	private String celularCliente;
	
	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<Comprobante> comprobante;
	
	
	public List<Comprobante> getComprobante() {
		return comprobante;
	}

	public void setComprobante(List<Comprobante> comprobante) {
		this.comprobante = comprobante;
	}

	public Cliente() {
	}

	public Cliente(Integer idCliente, String nombreCliente, String apellidoPaternoCliente,
			String apellidoMaternoCliente, String dniCliente, String rucCliente, Integer edad, String celularCliente,
			List<Comprobante> comprobante) 
	{
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoPaternoCliente = apellidoPaternoCliente;
		this.apellidoMaternoCliente = apellidoMaternoCliente;
		this.dniCliente = dniCliente;
		this.rucCliente = rucCliente;
		this.edad = edad;
		this.celularCliente = celularCliente;
		this.comprobante = comprobante;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoPaternoCliente() {
		return apellidoPaternoCliente;
	}

	public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
		this.apellidoPaternoCliente = apellidoPaternoCliente;
	}

	public String getApellidoMaternoCliente() {
		return apellidoMaternoCliente;
	}

	public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
		this.apellidoMaternoCliente = apellidoMaternoCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getRucCliente() {
		return rucCliente;
	}

	public void setRucCliente(String rucCliente) {
		this.rucCliente = rucCliente;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCelularCliente() {
		return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}
	
}
