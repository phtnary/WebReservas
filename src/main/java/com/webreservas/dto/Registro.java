package com.webreservas.dto;



public class Registro {
	
	private String nombre;
	private String apellidos;
	private String email;
	private String emailVerif;
	private String telefono;
	private String password;
	private String passwordVerif;
	
	
	
	public Registro () {
		
	}
	public Registro(String nombre, String apellidos, String email, String emailVerif, String telefono, String password,
			String passwordVerif) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.emailVerif = emailVerif;
		this.telefono = telefono;
		this.password = password;
		this.passwordVerif = passwordVerif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailVerif() {
		return emailVerif;
	}
	public void setEmailVerif(String emailVerif) {
		this.emailVerif = emailVerif;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordVerif() {
		return passwordVerif;
	}
	public void setPasswordVerif(String passwordVerif) {
		this.passwordVerif = passwordVerif;
	}
	
	
	
	
	

	

}
