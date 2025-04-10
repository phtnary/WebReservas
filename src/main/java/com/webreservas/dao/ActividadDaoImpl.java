package com.webreservas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.webreservas.model.Actividad;


@Repository
public class ActividadDaoImpl implements ActividadDao{

	@Autowired
	ActividadJpa actividadJpa;

	@Override
	public List<Actividad> getAllActividades() {
		
		return actividadJpa.findAll();
	}

	@Override
	public List<Actividad> getActividadesPorCiudadYPlazas(String ciudad, int plazas) {
		
		return actividadJpa.getActividadesPorCiudadYPlazas(ciudad,plazas);
	}

	@Override
	public Actividad getActividadById(int id) {
		
		return actividadJpa.findByIdActividad(id);
	}
	
	

}
