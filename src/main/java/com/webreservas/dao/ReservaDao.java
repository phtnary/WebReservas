package com.webreservas.dao;

import java.sql.Date;
import java.util.List;

import com.webreservas.model.Reserva;

public interface ReservaDao {

	List <Reserva> getAllReservas();
	List <Reserva> getByDate(Date date);
	List<Object[]> getReservasAgrupadasPorPlazas(Date fecha);
	Reserva insertarReserva(Reserva reserva);
	List<Reserva> getReservaByIdCliente(int id);
	
}
