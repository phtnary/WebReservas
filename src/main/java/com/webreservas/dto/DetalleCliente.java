package com.webreservas.dto;

	public class DetalleCliente {
		
			
		private int idCliente;
		private String nombre;
		private String apellidos;
		private String telefono;
		private String email;

		
		public DetalleCliente() {
			
		}
		
		public DetalleCliente(int id_cliente, String nombre, String apellidos, String telefono, String email) {
			this.idCliente = id_cliente;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.telefono = telefono;
			this.email = email;
		}

		public int getId_cliente() {
			return idCliente;
		}

		public void setId_cliente(int id_cliente) {
			this.idCliente = id_cliente;
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

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
}
