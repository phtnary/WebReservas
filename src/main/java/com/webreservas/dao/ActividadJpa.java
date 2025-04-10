package com.webreservas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webreservas.model.Actividad;



public interface ActividadJpa extends JpaRepository<Actividad, Integer> {
	@Query("SELECT a FROM Actividad a WHERE a.localidad = :ciudad AND a.plazas >= :plazas")
	public List<Actividad> getActividadesPorCiudadYPlazas(@Param("ciudad") String ciudad, @Param("plazas")int plazas);	
	
	Actividad findByIdActividad(int id);
	
	
}


