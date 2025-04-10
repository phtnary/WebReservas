package com.webreservas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



	@Entity
	@Table(name = "empresas")
	public class Empresa {
		
		@Id
		@Column(name = "id_empresa")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idEmpresa;
		
		@Column(name = "nombre")
		private String nombre;
		
		@Column(name = "direccion")
		private String direccion;
		
		@Column(name = "cp")
		private int cp;
		
		@Column(name = "telefono")
		private int telefono;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "latitud")
		private double latitud;
		
		@Column(name = "longitud")
		private double longitud;
		
		
		public Empresa() {
			
		}

		public Empresa(int idEmpresa, String nombre, String direccion, int cp, int telefono, String email,  double latitud,  double longitud ) {
			this.idEmpresa = idEmpresa;
			this.nombre = nombre;
			this.direccion = direccion;
			this.cp = cp;
			this.telefono = telefono;
			this.email = email;
			this.latitud=latitud;
			this.longitud=longitud;
		}

		

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public double getCp() {
			return cp;
		}

		public void setCp(int cp) {
			this.cp = cp;
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getIdEmpresa() {
			return idEmpresa;
		}

		public void setIdEmpresa(int idEmpresa) {
			this.idEmpresa = idEmpresa;
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

