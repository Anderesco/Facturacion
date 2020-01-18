package com.ejemplo.spring.facturacion.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comprobante")
public class Comprobante 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer idComprobante;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	Cliente cliente;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	Libro libro;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	Sede sede;
	
	@JoinColumn
	@OneToOne(cascade = CascadeType.ALL)
	DetalleComprobante detallecomprobante;
	
	@Column(name = "FechaCreacion")
	private Date fechaCreacion;
	
	@Column(name = "Estado")
	private String estadoComprobante;
	
	@Column(name = "FechaEmision")
	private Date fechaEmision;
	
	@Column(name = "MontoTotal")
	private Float montoTotal;
}
