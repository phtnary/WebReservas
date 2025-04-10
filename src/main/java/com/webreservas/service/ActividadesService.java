package com.webreservas.service;

import java.util.List;

import com.webreservas.dto.FormHome;
import com.webreservas.dto.InfoActividad;
import com.webreservas.model.Actividad;



public interface ActividadesService {
	List <Actividad> getAllActivities();
	List <InfoActividad> getActividadesDisponibles(FormHome datosBusqueda);
	
}
