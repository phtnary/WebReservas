package com.webreservas.service;

import java.util.List;

import com.webreservas.dto.DetalleReserva;
import com.webreservas.dto.FormHome;
import com.webreservas.model.Reserva;

public interface ReservasService {
	List <Reserva> getAllReservas();
	public DetalleReserva getDetalleReserva(FormHome formhome, int idActividad);
	public List<Reserva> getAllReserservasbyCliente(int idCliente);
	public Reserva insertarReserva(FormHome formHome, int idActividad);
	public List<DetalleReserva> getHistorialReservas (int idCliente);
	public String crearMensajeReservaOk();
	public void resetearMensajeReservaOk();
}
