package com.webreservas.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actividades")
public class Actividad {
	
		@Id
		@Column(name = "id_actividad")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idActividad;
		
		@Column(name = "id_tipo")
		private int id_tipo;
		
		@Column(name = "duracion")
		private int duracion;
		
		@Column(name = "precio")
		private double precio;
		
		@Column(name = "localidad")
		private String localidad;
		
		@Column(name = "id_empresa")
		private int id_empresa;
		
		@Column(name = "plazas")
		private int plazas;
		
		@Column(name = "hora")
		private String hora;
		
		
		
		
		public Actividad() {
			
		}
		
		public Actividad(int id_actividad, int id_tipo, int duracion, double precio, String localidad, int id_empresa,
				int plazas, String hora) {
			this.idActividad = id_actividad;
			this.id_tipo = id_tipo;
			this.duracion = duracion;
			this.precio = precio;
			this.localidad = localidad;
			this.id_empresa = id_empresa;
			this.plazas = plazas;
			this.hora=hora;
		}

		public int getIdActividad() {
			return idActividad;
		}

		public void setIdActividad(int idActividad) {
			this.idActividad = idActividad;
		}

		public int getId_tipo() {
			return id_tipo;
		}

		public void setId_tipo(int id_tipo) {
			this.id_tipo = id_tipo;
		}

		public int getDuracion() {
			return duracion;
		}

		public void setDuracion(int duracion) {
			this.duracion = duracion;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public String getLocalidad() {
			return localidad;
		}

		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}

		public int getId_empresa() {
			return id_empresa;
		}

		public void setId_empresa(int id_empresa) {
			this.id_empresa = id_empresa;
		}

		public int getPlazas() {
			return plazas;
		}

		public void setPlazas(int plazas) {
			this.plazas = plazas;
		}
		
		public String getHora() {
			return hora;
		}

		public void setHora(String hora) {
			this.hora = hora;
		}	

}
