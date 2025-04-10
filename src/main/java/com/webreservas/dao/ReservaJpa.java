package com.webreservas.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.webreservas.model.Reserva;

public interface ReservaJpa extends JpaRepository<Reserva, Integer> {
	List<Reserva> findByFechaReserva(Date date);
	
	@Query("SELECT r.id_actividad, r.fechaReserva, SUM(r.num_plazas) FROM Reserva r WHERE r.fechaReserva=:fecha GROUP BY r.id_actividad, r.fechaReserva")
	public List<Object[]> getReservasAgrupadasPorPlazas(@Param("fecha") Date fecha);
	
	List<Reserva> findByIdCliente(int idCliente);
	
	
}
