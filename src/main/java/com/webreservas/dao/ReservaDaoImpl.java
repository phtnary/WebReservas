package com.webreservas.dao;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webreservas.model.Reserva;


@Repository

public class ReservaDaoImpl implements ReservaDao{
	
	@Autowired
	ReservaJpa reservaJpa;

	@Override
	public List<Reserva> getAllReservas() {
		
		return  reservaJpa.findAll();
	}

	@Override
	public List<Reserva> getByDate(Date date) {
		return  reservaJpa.findByFechaReserva(date);
		
	}
	public List<Object[]> getReservasAgrupadasPorPlazas( Date fecha){
		return reservaJpa.getReservasAgrupadasPorPlazas(fecha);
	}

	@Override
	public Reserva insertarReserva(Reserva reserva) {
		return reservaJpa.save(reserva);
		
	}

	@Override
	public List<Reserva> getReservaByIdCliente(int id) {
		
		return reservaJpa.findByIdCliente(id);
	}

	
	

	
	
}
