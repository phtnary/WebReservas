package com.webreservas.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webreservas.dao.ActividadDao;
import com.webreservas.dao.ClienteDao;
import com.webreservas.dao.EmpresaDao;
import com.webreservas.dao.ReservaDao;
import com.webreservas.dao.TipoAventuraDao;
import com.webreservas.dto.DetalleReserva;
import com.webreservas.dto.FormHome;
import com.webreservas.model.Actividad;
import com.webreservas.model.Empresa;
import com.webreservas.model.Reserva;
import com.webreservas.model.TipoAventura;

@Service
public class ReservasServiceImpl implements ReservasService {
	@Autowired
	ReservaDao reservaDao;
	
	@Autowired
	 ActividadDao actividadesDao;
	
	@Autowired
	TipoAventuraDao tipoAventuraDao;
	
	@Autowired
	EmpresaDao empresaDao;
	
	@Autowired
	ClienteDao clienteDao;
	
	@Autowired
	SecurityService securityService;
	
	public boolean esReservaConfirmada=false;
	
	
	@Override
	public List<Reserva> getAllReservas() {
		
		 return reservaDao.getAllReservas();
	}
	
	
	@Override
	public DetalleReserva getDetalleReserva(FormHome formHome, int idActividad) {
		
		DetalleReserva detalleReserva = new DetalleReserva();
		
		detalleReserva.setCiudad(formHome.getCiudad());
		detalleReserva.setDate(formHome.getDate());
		detalleReserva.setNumPersonas(formHome.getNumPersonas());
		detalleReserva.setIdActividad(idActividad);
		
		Actividad actividad= actividadesDao.getActividadById(idActividad);
		int idTipo =actividad.getId_tipo();
		
		TipoAventura tipoAventura=tipoAventuraDao.getTipoAventuraById(idTipo);
		String nombreAventura=tipoAventura.getNombre();
		
		
		detalleReserva.setNombreActividad(nombreAventura);
		
		int idEmpresa=actividad.getId_empresa();
		
		Empresa empresa= empresaDao.getEmpresaById(idEmpresa);
		
		String nombreEmpresa= empresa.getNombre();
		detalleReserva.setEmpresa( nombreEmpresa);
		
		detalleReserva.setDireccion(empresa.getDireccion());
		detalleReserva.setDuracion(actividad.getDuracion());
		detalleReserva.setPrecioPorPersona(actividad.getPrecio());
		detalleReserva.calcularPrecioTotal();
		detalleReserva.setHora(actividad.getHora());
		detalleReserva.setEmailEmpresa(empresa.getEmail());
		detalleReserva.setTelefonoEmpresa(empresa.getTelefono());
		
		
		return detalleReserva;
	}

	public Reserva insertarReserva(FormHome formHome, int idActividad) {
		
		Reserva reserva=new Reserva();
		
		//Obtengo id_empresa
		Actividad actividad= actividadesDao.getActividadById(idActividad);
		int idEmpresa=actividad.getId_empresa();
		
		reserva.setId_empresa(idEmpresa);
		reserva.setId_actividad(idActividad);
		reserva.setId_cliente(securityService.obtenerIdUsuarioDeSesion());
		
		//Transforma fecha de java.util.date a Java.sql.date
		Date fecha= new Date(formHome.getDate().getTime());
		reserva.setFechaReserva(fecha);
		reserva.setNum_plazas(formHome.getNumPersonas());
		
		reserva.setPrereserva(false);
		reservaDao.insertarReserva(reserva);
		this.esReservaConfirmada=true;
		
		return reserva;
	}
	
		public List<Reserva> getAllReserservasbyCliente(int idCliente){
			
			List<Reserva> reservasPorCliente = reservaDao.getReservaByIdCliente (idCliente);
			
		return reservasPorCliente;
	}
		
		public DetalleReserva getDetalleReserva(Reserva reserva) {
			
			DetalleReserva detalleReserva =new DetalleReserva();
			
			
			
			detalleReserva.setDate(reserva.getFechaReserva());
			detalleReserva.setNumPersonas(reserva.getNum_plazas());
			detalleReserva.setIdActividad(reserva.getId_actividad());
			
			Actividad actividad= actividadesDao.getActividadById(reserva.getId_actividad());
			int idTipo =actividad.getId_tipo();
			
			String ciudad=actividad.getLocalidad();
			
			detalleReserva.setCiudad(ciudad);
			
			TipoAventura tipoAventura=tipoAventuraDao.getTipoAventuraById(idTipo);
			String nombreAventura=tipoAventura.getNombre();
			
			
			detalleReserva.setNombreActividad(nombreAventura);
			
			int idEmpresa=actividad.getId_empresa();
			
			Empresa empresa= empresaDao.getEmpresaById(idEmpresa);
			
			String nombreEmpresa= empresa.getNombre();
			detalleReserva.setEmpresa( nombreEmpresa);
			
			detalleReserva.setDireccion(empresa.getDireccion());
			detalleReserva.setDuracion(actividad.getDuracion());
			detalleReserva.setPrecioPorPersona(actividad.getPrecio());
			
			detalleReserva.calcularPrecioTotal();
			detalleReserva.setHora(actividad.getHora());
			detalleReserva.setEmailEmpresa(empresa.getEmail());
			detalleReserva.setTelefonoEmpresa(empresa.getTelefono());
			
			
			return detalleReserva;
		}
		
		
		public List<DetalleReserva> getHistorialReservas (int idCliente){
			
			List<Reserva> reservasPorCliente = getAllReserservasbyCliente(idCliente);
			List<DetalleReserva> listaDetalleReserva= new ArrayList<DetalleReserva>();
			
			for (Reserva reserva : reservasPorCliente) {
				DetalleReserva detalleReserva= getDetalleReserva(reserva);
				
				listaDetalleReserva.add(detalleReserva);
			}
			
			return listaDetalleReserva; 
		}
		
		public String crearMensajeReservaOk() {
			
			String mensaje="";
			if(this.esReservaConfirmada==false) {
				mensaje="";
			}else {
				mensaje="Tu reserva está confirmada ¡Ahora solo queda disfrutarla!";
			}
		
			
			return mensaje;
		}
		
		public void resetearMensajeReservaOk() {
			this.esReservaConfirmada=false;
		}
		
		
		
	
}
