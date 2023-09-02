package com.inventory.app.controller.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Column(name = "nombre")
	private String nombre;

	@NotNull
	@Column(name = "edad")
	private Integer edad;

	@NotNull
	@Column(name = "id_rol")
	private Integer idRol;

	@NotNull
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	public User() {
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", idRol=" + idRol + ", fechaIngreso="
				+ fechaIngreso + "]";
	}
	
}
