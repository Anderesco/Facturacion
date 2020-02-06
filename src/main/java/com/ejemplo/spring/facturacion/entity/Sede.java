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
@Table(name = "sede")
public class Sede 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idSede;
	
	@Column(name = "Nombre")
	private String nombreSede;
	
	@Column(name = "Direccion")
	private String direccionSede;
	
	@Column(name = "Telefono")
	private String telefonoSede;

	@JoinColumn
	@OneToMany(cascade = CascadeType.ALL)
	private List<Comprobante> comprobante;
	
	public Sede() {
		super();
	}

	public Sede(String nombreSede, String direccionSede, String telefonoSede, List<Comprobante> comprobante) {
		this.nombreSede = nombreSede;
		this.direccionSede = direccionSede;
		this.telefonoSede = telefonoSede;
		this.comprobante = comprobante;
	}

	
	public List<Comprobante> getComprobante() {
		return comprobante;
	}

	public void setComprobante(List<Comprobante> comprobante) {
		this.comprobante = comprobante;
	}

	public Long getIdSede() {
		return idSede;
	}

	public void setIdSede(Long idSede) {
		this.idSede = idSede;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public String getDireccionSede() {
		return direccionSede;
	}

	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
	}

	public String getTelefonoSede() {
		return telefonoSede;
	}

	public void setTelefonoSede(String telefonoSede) {
		this.telefonoSede = telefonoSede;
	}

	@Override
	public String toString() {
		return "Sede{" +
				"idSede=" + idSede +
				", nombreSede='" + nombreSede + '\'' +
				", direccionSede='" + direccionSede + '\'' +
				", telefonoSede='" + telefonoSede + '\'' +
				", comprobante=" + comprobante +
				'}';
	}
}
