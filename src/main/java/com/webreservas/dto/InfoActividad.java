package com.webreservas.dto;

public class InfoActividad {
	
	
	 private String nombreActividad;
	 private int numPlazas;
	 private String ciudad;
	 private int duracion;
	 private double precioPorPersona;
	 private int numPersonas;
	 private double precioTotal;
	 private int idActividad; 
	 private String hora;
	 private String nombreEmpresa;
	 private double latitud;
	 private double longitud;
	 
	
 
 public InfoActividad() {
	 
 }
 
 
 
 public InfoActividad(String nombreActividad, int numPlazas, String ciudad, int duracion, double precioPorPersona,
		int numPersonas, int idActividad, String hora,String nombreEmpresa, double latitud, double longitud) {
	
	this.nombreActividad = nombreActividad;
	this.numPlazas = numPlazas;
	this.ciudad = ciudad;
	this.duracion = duracion;
	this.precioPorPersona = precioPorPersona;
	this.numPersonas = numPersonas;
	calcularPrecioTotal();
	this.idActividad= idActividad;
	this.hora=hora;
	this.nombreEmpresa=nombreEmpresa;
	this.latitud=latitud;
	this.longitud=longitud;
	
	
}
public int getIdActividad() {
	return idActividad;
}



public void setIdActividad(int idActividad) {
	this.idActividad = idActividad;
}



public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
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



	public String getNombreEmpresa() {
		return nombreEmpresa;
	}



	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}



	public double getLatitud() {
		return latitud;
	}



	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}



	public double getLongitud() {
		return longitud;
	}



	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	
}


