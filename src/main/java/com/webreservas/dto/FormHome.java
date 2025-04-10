package com.webreservas.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FormHome {
	private String ciudad;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private int numPersonas;
	
	public FormHome() {
		
	}
	public FormHome(String ciudad, Date date, int numPersonas) {
		super();
		this.ciudad = ciudad;
		this.date = date;
		this.numPersonas = numPersonas;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	
	
}
