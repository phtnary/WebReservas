package com.webreservas.service;

import java.util.List;

import com.webreservas.dto.DetalleCliente;
import com.webreservas.dto.Registro;
import com.webreservas.model.Cliente;

public interface ClientesService {
	List <Cliente> getAllClientes();
	DetalleCliente getDetalleCliente(int id);
	Cliente addRegistroCliente(Registro registro);
	Cliente modificarRegistroCliente( DetalleCliente detalleCliente, int idCliente);
	boolean borrarRegistroCliente( int idUsuarioSesion); 
	boolean ComprobarReservaPendiente(int idUsuarioSesion);
	String crearMensajeReservaPendienteCliente();
	void resetearMensajeTieneReserva();
	String crearMensajeEmailExiste(String email);
}
