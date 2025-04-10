package com.webreservas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposaventura")
public class TipoAventura {

	@Id
	@Column(name = "id_tipo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipo;
	
	@Column(name = "nombre")
	private String nombre;

	public TipoAventura() {
	}
	
	public TipoAventura(int id_tipo, String nombre) {
		this.idTipo = id_tipo;
		this.nombre = nombre;
	}

	public int getId_tipo() {
		return idTipo;
	}

	public void setId_tipo(int id_tipo) {
		this.idTipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
