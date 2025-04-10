package com.webreservas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	@Entity
	@Table(name = "clientes")
	public class Cliente {
		
			@Id
			@Column(name = "id_cliente")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int idCliente;
			
			@Column(name = "nombre")
			private String nombre;
			
			@Column(name = "apellidos")
			private String apellidos;
			
			@Column(name = "telefono")
			private String telefono;
			
			@Column(name = "email")
			private String email;
			
			@Column(name = "password")
			private String password;

			
			public Cliente() {
				
			}
			
			public Cliente(int id_cliente, String nombre, String apellidos, String telefono, String email, String password) {
				this.idCliente = id_cliente;
				this.nombre = nombre;
				this.apellidos = apellidos;
				this.telefono = telefono;
				this.email = email;
				this.password=password;
			}

			public int getIdCliente() {
				return idCliente;
			}

			public void setIdCliente(int idCliente) {
				this.idCliente = idCliente;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
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
