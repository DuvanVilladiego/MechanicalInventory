package com.inventory.app.dto;

import javax.validation.constraints.NotNull;

public class GeneralResponseDTO {
	
	@NotNull
	private String message;
	@NotNull
	private Boolean status;
	@NotNull
	private Object data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public GeneralResponseDTO(String message, Boolean status, Object data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}
	
}
