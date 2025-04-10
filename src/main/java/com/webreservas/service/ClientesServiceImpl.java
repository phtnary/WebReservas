package com.webreservas.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.webreservas.dao.ClienteDao;
import com.webreservas.dao.ReservaDao;
import com.webreservas.dto.DetalleCliente;
import com.webreservas.dto.Registro;
import com.webreservas.model.Actividad;
import com.webreservas.model.Cliente;
import com.webreservas.model.Reserva;

@Service
public class ClientesServiceImpl implements  ClientesService {
	@Autowired
	 ClienteDao  clienteDao;
	
	@Autowired
	 ReservaDao  reservaDao;

	@Override
	public List<Cliente> getAllClientes() {
		
		 return clienteDao.getAllClientes();
	}
	
	public boolean mensajeTieneReserva=false;
	

	@Override
	public DetalleCliente getDetalleCliente(int id) {
		
		Cliente cliente=clienteDao.getClienteById(id);
		
		DetalleCliente detalleCliente= new DetalleCliente();
		
		detalleCliente.setNombre(cliente.getNombre());
		detalleCliente.setApellidos(cliente.getApellidos());
		detalleCliente.setEmail(cliente.getEmail());
		detalleCliente.setTelefono(cliente.getTelefono());
		
		return detalleCliente;
	}
	
	public Cliente addRegistroCliente( Registro registro) {
		
		//Si no hay usuario con ese email devuelve null
		Cliente cliente = clienteDao.getClienteByEmail(registro.getEmail());
		if (cliente==null) {
			
			//Como no existe en base de datos creo la instancia del cliente
			cliente = new Cliente();
			cliente.setNombre(registro.getNombre());
			cliente.setApellidos(registro.getApellidos());
			
			cliente.setEmail(registro.getEmail());
			cliente.setTelefono(registro.getTelefono());
			
			//Encripto la contraseña
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String passwordEncrypt= encoder.encode(registro.getPassword());
			cliente.setPassword(passwordEncrypt);
			
			return clienteDao.insertarCliente(cliente);
			
		}else {
			
			return null;
		}
		
		
		// Se comprueba si el usuario existe
		
	}
	
	public Cliente modificarRegistroCliente( DetalleCliente detalleCliente, int idCliente) {
		Cliente cliente = clienteDao.getClienteById(idCliente);
		
		cliente.setNombre(detalleCliente.getNombre());
		cliente.setApellidos(detalleCliente.getApellidos());
		cliente.setEmail(detalleCliente.getEmail());
		cliente.setTelefono(detalleCliente.getTelefono());
		
		return  clienteDao.insertarCliente(cliente);
	}
	
	public boolean ComprobarReservaPendiente(int idUsuarioSesion) {
		
		List<Reserva> listaReservas= reservaDao.getReservaByIdCliente(idUsuarioSesion);
		
		//Fecha actual para calendario
		LocalDate localDate = LocalDate.now();
		        
	   // Convertir LocalDate a java.sql.Date porque en la lista viene como sql date
	   Date fechaActual = Date.valueOf(localDate);
	   
	   boolean flag=false;
	   
	   for (Reserva reserva : listaReservas) {
		   if (reserva.getFechaReserva().after(fechaActual)) {
			   flag=true;
		   } else {
			   flag=false;
		   }
	   }
		   
		return flag;
	}
	
	public boolean borrarRegistroCliente( int idUsuarioSesion) {
		
		boolean tieneReservasPendientes=ComprobarReservaPendiente(idUsuarioSesion);
		
		if(tieneReservasPendientes==true) {
		
		this.mensajeTieneReserva=true;
		return true;
		
		}else {
			
			clienteDao.borrarRegistroCliente(idUsuarioSesion);
			this.mensajeTieneReserva=false;
			return false;
		}
	}
	
	
	public String crearMensajeReservaPendienteCliente() {
		
		String mensaje="";
		if(this.mensajeTieneReserva==false) {
			mensaje="";
		}else {
			mensaje="Todavía no es posible borrar tu perfil.Tienes reservas pendientes";
		}
	
		
		return mensaje;
	}
	
	public void resetearMensajeTieneReserva() {
		this.mensajeTieneReserva=false;
	}
	
	public String crearMensajeEmailExiste(String email) {
		
		 Cliente cliente= clienteDao.getClienteByEmail(email);
		 if(cliente!=null) {
			 return "Este email ya existe";
		 } else {
			 return "";
		
		 }
	}
}

