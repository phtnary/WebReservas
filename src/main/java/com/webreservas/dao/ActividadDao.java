package com.webreservas.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.webreservas.model.Actividad;
import com.webreservas.model.TipoAventura;



public interface ActividadDao {

	List <Actividad> getAllActividades();
	List<Actividad> getActividadesPorCiudadYPlazas(String ciudad,int plazas);
	Actividad getActividadById(int id);
}
