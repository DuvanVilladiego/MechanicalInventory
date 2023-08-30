package com.inventory.app.dto.products;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ProductDTO {
	
	@NotNull
	private String Nombre;
	@NotNull
	private Integer Cantidad;
	@NotNull
	private Date fechaIngreso;
	@NotNull
	private String Usuario;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Integer getCantidad() {
		return Cantidad;
	}
	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

}
