package com.webreservas.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DetalleReserva {
	
	 private String nombreActividad;
	 private String empresa;
	 private String ciudad;
	 private String direccion;
	 private double precioPorPersona;
	 private double duracion;
	 private int numPersonas;
	 private double precioTotal;
	 private int idActividad;
	 private String hora;
	 private String emailEmpresa;
	 private int telefonoEmpresa;
	 
	 
	 
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date date;
	 
	 public DetalleReserva() {
		 
	 }

	public DetalleReserva(String nombreActividad, String empresa, String ciudad, String direccion,
		double precioPorPersona,double duracion, int numPersonas, int idActividad, Date date, String hora, String emailEmpresa,
	      int telefonoEmpresa) {
		super();
		this.nombreActividad = nombreActividad;
		this.empresa = empresa;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.precioPorPersona = precioPorPersona;
		this.duracion = duracion;
		this.numPersonas = numPersonas;
		calcularPrecioTotal();
		this.idActividad = idActividad;
		this.date = date;
		this.hora= hora;
		this.emailEmpresa=emailEmpresa;
		this.telefonoEmpresa=telefonoEmpresa;
		
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPrecioPorPersona() {
		return precioPorPersona;
	}

	public void setPrecioPorPersona(double precioPorPersona) {
		this.precioPorPersona = precioPorPersona;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void calcularPrecioTotal() {
		
		 setPrecioTotal(precioPorPersona*numPersonas);
		 
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}

	private void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public int getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(int telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}
	
	
	
	
	 
	 
	 
}
