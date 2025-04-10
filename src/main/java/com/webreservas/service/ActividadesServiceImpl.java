package com.webreservas.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webreservas.dao.ActividadDao;
import com.webreservas.dao.EmpresaDao;
import com.webreservas.dao.ReservaDao;
import com.webreservas.dao.TipoAventuraDao;
import com.webreservas.dto.FormHome;
import com.webreservas.dto.InfoActividad;
import com.webreservas.model.Actividad;
import com.webreservas.model.Empresa;
import com.webreservas.model.Reserva;

@Service
public class ActividadesServiceImpl implements ActividadesService {
	
	@Autowired
	 ActividadDao actividadesDao;
	@Autowired
	 ReservaDao reservasDao;
	@Autowired
	TipoAventuraDao tipoAventuraDao;
	
	@Autowired
	EmpresaDao empresaDao;
	
	List <InfoActividad> inforActividades = new ArrayList<>();
	
	@Override
	public List<Actividad> getAllActivities() {
		
		 return actividadesDao.getAllActividades();
	}

	@Override
	public List<InfoActividad> getActividadesDisponibles(FormHome datosBusqueda) {
		
		inforActividades.clear();
		
		int numPersonas=datosBusqueda.getNumPersonas();
		Date fecha= new Date(datosBusqueda.getDate().getTime());
		String ciudad=datosBusqueda.getCiudad();
		
		List<Actividad> actividadesDisponibles = actividadesDao.getActividadesPorCiudadYPlazas(ciudad, numPersonas);
		
		
		List<Object[]> reservasPorFechaAgrupPorPlazas = reservasDao.getReservasAgrupadasPorPlazas(fecha);
	
		
		
		for (Actividad actividad : actividadesDisponibles) {
            InfoActividad inforActividad =new InfoActividad();
            inforActividad.setDuracion(actividad.getDuracion());
            inforActividad.setNombreActividad(tipoAventuraDao.getTipoAventuraById(actividad.getId_tipo()).getNombre());
            inforActividad.setNumPersonas(numPersonas);
            inforActividad.setPrecioPorPersona(actividad.getPrecio());
            inforActividad.setCiudad(ciudad);
            inforActividad.calcularPrecioTotal();
            inforActividad.setIdActividad(actividad.getIdActividad());
            inforActividad.setHora(actividad.getHora());
            
            int idEmpresa=actividad.getId_empresa();
            Empresa empresa=empresaDao.getEmpresaById(idEmpresa);
            inforActividad.setNombreEmpresa(empresa.getNombre());
            inforActividad.setLatitud(empresa.getLatitud());
            inforActividad.setLongitud(empresa.getLongitud());
            
            
            
            int plazasDisponibles=actividad.getPlazas();
    		
            for (Object[] resultado : reservasPorFechaAgrupPorPlazas) {
            	
            	Integer idActividad = (Integer) resultado[0];
    		    Date fechaReserva = (Date) resultado[1];
    		    Long totalPlazas = (Long) resultado[2];
    		    
            	if(actividad.getIdActividad()==idActividad) {
		    		plazasDisponibles=(int) (plazasDisponibles-totalPlazas) ;
		    	}
            }
            inforActividad.setNumPlazas(plazasDisponibles);
            if(plazasDisponibles>=numPersonas) {
            	inforActividades.add(inforActividad);
            }
        }
		
		return inforActividades;
		
		
	}
  
}
