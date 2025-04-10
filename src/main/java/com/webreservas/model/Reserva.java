package com.webreservas.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
	
	
	@Id
	@Column(name = "id_reserva")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	
	@Column(name = "id_empresa")
	private int id_empresa;
	
	@Column(name = "id_actividad")
	private int id_actividad;
	
	@Column(name = "id_cliente")
	private int idCliente;
	
	@Column(name = "fecha_reserva")
	private Date fechaReserva;
	
	@Column(name = "num_plazas")
	private int num_plazas;

	@Column(name = "prereserva")
	private boolean prereserva;

	

	public Reserva() {
		
	}
	
	public Reserva(int id_reserva, int id_empresa, int id_actividad, int id_cliente, Date fecha_reserva,
		int num_plazas,boolean prereserva) {
		this.idReserva = id_reserva;
		this.id_empresa = id_empresa;
		this.id_actividad = id_actividad;
		this.idCliente = id_cliente;
		this.fechaReserva = fecha_reserva;
		this.num_plazas = num_plazas;
		this.prereserva = prereserva;
	}

	public int getId_reserva() {
		return idReserva;
	}

	public void setId_reserva(int id_reserva) {
		this.idReserva = id_reserva;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public int getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}

	public int getId_cliente() {
		return idCliente;
	}

	public void setId_cliente(int id_cliente) {
		this.idCliente = id_cliente;
	}
	
	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public boolean isPrereserva() {
		return prereserva;
	}

	public void setPrereserva(boolean prereserva) {
		this.prereserva = prereserva;
	}

	public int getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}
	
	
	
	
	
	
	
	
	
	
	

}
