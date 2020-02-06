package com.ejemplo.spring.facturacion.bean;

import java.io.Serializable;

public class SedeBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Integer ID;
	private String nombreSede;
	private String direccionSede;
	private String telefonoSede;
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		this.ID = iD;
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
}
