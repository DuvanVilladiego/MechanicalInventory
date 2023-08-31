package com.inventory.app.controller.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mercancia")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@Column(name = "id_user")
	private Integer idUser;

	public Product() {
	}

	public Product(long id, String nombre, Integer cantidad, Date fechaIngreso, Integer idUser) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.idUser = idUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", fechaIngreso=" + fechaIngreso
				+ ", idUser=" + idUser + "]";
	}	
	
}
