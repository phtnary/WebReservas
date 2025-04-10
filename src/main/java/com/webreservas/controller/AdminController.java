package com.webreservas.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.webreservas.dto.DetalleCliente;
import com.webreservas.dto.DetalleReserva;
import com.webreservas.dto.FormHome;
import com.webreservas.dto.InfoActividad;
import com.webreservas.dto.Registro;
import com.webreservas.model.Ciudad;
import com.webreservas.model.Reserva;
import com.webreservas.service.ActividadesService;
import com.webreservas.service.CiudadesService;
import com.webreservas.service.ClientesService;
import com.webreservas.service.ReservasService;
import com.webreservas.service.SecurityService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	ActividadesService actividadesService;
	
	@Autowired
	ReservasService reservaService;
	
	@Autowired
	ClientesService clientesService;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	CiudadesService ciudadesService;
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String mostrarHomeView(Model model,HttpSession session) {
		FormHome datos = new FormHome();
		
		
		session.setAttribute("idActividad", -1);
		
		String usuarioSesion= securityService.obtenerUsuarioDeSesion();
		if(usuarioSesion!="anonymousUser") {
			
			return  "redirect:/myHome";
		}
		
		
		//Fecha actual
		LocalDate localDate = LocalDate.now();
        
        // Convertir LocalDate a java.sql.Date
        Date fechaActual = Date.valueOf(localDate);
        
        //Lista de ciudades para mostrar en select
        List <Ciudad> listaCiudades = new ArrayList<>();
        listaCiudades=ciudadesService.ObtenerCiudades();
        
        model.addAttribute("listaCiudades",listaCiudades);
        model.addAttribute("fechaActual",fechaActual);
		model.addAttribute("datosBusqueda",datos);
		return "home";
	}
	
	@RequestMapping(value="/myHome", method=RequestMethod.GET)
	public String mostrarMyHomeView(Model model,HttpSession session) {
		FormHome datos = new FormHome();
		session.setAttribute("idActividad", -1);
		
		//Fecha actual para calendario
		LocalDate localDate = LocalDate.now();
        
        // Convertir LocalDate a java.sql.Date
        Date fechaActual = Date.valueOf(localDate);
		
		//Lista de ciudades para mostrar en select
        List <Ciudad> listaCiudades = new ArrayList<>();
        listaCiudades=ciudadesService.ObtenerCiudades();
        
        model.addAttribute("fechaActual",fechaActual);
        model.addAttribute("listaCiudades",listaCiudades);
		String usuarioSesion= securityService.obtenerUsuarioDeSesion();
		model.addAttribute("usuarioSesion",usuarioSesion);
		model.addAttribute("datosBusqueda",datos);
		return "myHome";
	}
	
	
	
	@RequestMapping(value="/actividades", method=RequestMethod.POST)
	public String BuscarYMostrarActividadesView(@ModelAttribute("datosBusqueda") FormHome datosBusqueda,HttpSession session, Model model) {
		
		
		session.setAttribute("datosBusqueda", datosBusqueda);
		
		
		return "redirect:/actividades";
		
	}
	
	@RequestMapping(value="/actividades", method=RequestMethod.GET)
	public String volverActividadesDesdePerfilView(HttpSession session, Model model) {
		
		FormHome datosBusqueda=(FormHome)session.getAttribute("datosBusqueda");
		List <InfoActividad> inforActividades = new ArrayList<>();
		inforActividades=actividadesService.getActividadesDisponibles(datosBusqueda);
		
		//Convierto lista actividades a JSON para transportar las coordenadas
		
		Gson gson=new Gson();
		String arrayJson=gson.toJson(inforActividades);
		
		//obtengo nombre de usuario de SpringSecurity
		
		String usuarioSesion= securityService.obtenerUsuarioDeSesion();
		
		//Paso los datos a la vista actividades
		
		model.addAttribute("usuarioSesion",usuarioSesion);
		model.addAttribute("arrayJson",arrayJson);
		model.addAttribute("datosBusqueda",datosBusqueda);
		model.addAttribute("inforActividades",inforActividades);
		
		
		return "actividades";
	}
	
	@RequestMapping(value="/detalleReserva", method=RequestMethod.GET)
	public String mostrarDetallesReservaView(@RequestParam(value="idActividad") String idActividad, HttpSession session, Model model) {
		
		
		//Obtengo nombre usuario sesión para nav-log
		String usuarioSesion= securityService.obtenerUsuarioDeSesion();
		model.addAttribute("usuarioSesion",usuarioSesion);
		
		
		FormHome datosBusqueda = (FormHome) session.getAttribute("datosBusqueda");
		session.setAttribute("idActividad", Integer.parseInt(idActividad));
		
		DetalleReserva detalleReserva=reservaService.getDetalleReserva(datosBusqueda,Integer.parseInt(idActividad));
		
		//Obtengo idCliente de sesionSecurity para mandar a la vista los datos personales de detalle reserva.
		
		int idUsuarioSesion= securityService.obtenerIdUsuarioDeSesion();
		model.addAttribute("idUsuarioSesion",idUsuarioSesion);
		DetalleCliente detalleCliente=clientesService.getDetalleCliente(idUsuarioSesion);
		
		model.addAttribute("detalleReserva",detalleReserva);
		model.addAttribute("detalleCliente",detalleCliente);
		
		
		return "detalleReserva";
	}
	
	@RequestMapping(value="/persisteReserva", method=RequestMethod.GET)
	public String guardarEnBaseDatosYMostrarMiPerfilView( HttpSession session, Model model) {
		
		FormHome datosBusqueda = (FormHome) session.getAttribute("datosBusqueda");
		int idActividad=(int) session.getAttribute("idActividad");
		reservaService.insertarReserva(datosBusqueda, idActividad);
		
		
		return "redirect:/miPerfil";
	}
	
	@RequestMapping(value="/miPerfil", method=RequestMethod.GET)
	public String mostrarMiPerfilView( HttpSession session, Model model){
		
		
		int idUsuarioSesion= securityService.obtenerIdUsuarioDeSesion();
		DetalleCliente detalleCliente=clientesService.getDetalleCliente(idUsuarioSesion);
		
		String usuarioSesion= securityService.obtenerUsuarioDeSesion();
		model.addAttribute("usuarioSesion",usuarioSesion);
		
		LocalDate localDate = LocalDate.now();
        
        // Convertir LocalDate a java.sql.Date
        Date fechaActual = Date.valueOf(localDate);
       
		
		List <DetalleReserva>listaReservas= reservaService.getHistorialReservas(idUsuarioSesion);
		model.addAttribute("fechaActual",fechaActual);
		model.addAttribute("listaReservas",listaReservas);
		model.addAttribute("detalleCliente",detalleCliente);
		
		return "miPerfil";
	}

	@RequestMapping(value="/registro", method=RequestMethod.GET)
	public String registroView(Model model) {
		Registro datosRegistro= new Registro();
		model.addAttribute("datosRegistro",datosRegistro);
		return "registro";
	}
	
	@RequestMapping(value="/addregistro", method=RequestMethod.POST)
	public String insertarClienteYMostrarDetalleReservaView(@ModelAttribute("datosRegistro") Registro datosRegistro,HttpSession session,Model model) {
		clientesService.addRegistroCliente(datosRegistro);
		
		int idActividad=(int) session.getAttribute("idActividad");
		
		if(idActividad==-1) {
			return "redirect:/myHome";
		}else {
			return "redirect:/detalleReserva?idActividad=" + String.valueOf(idActividad);
		}
	}
	
	@RequestMapping(value="/modificaPerfil", method=RequestMethod.POST)
	public String actualizaPerfilView(@ModelAttribute("detalleCliente") DetalleCliente detalleCliente,HttpSession session,Model model) {
		
		int idUsuarioSesion= securityService.obtenerIdUsuarioDeSesion();

		clientesService.modificarRegistroCliente(detalleCliente,idUsuarioSesion);
		return "redirect:/miPerfil";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/borrarPerfil", method = RequestMethod.GET)
	public String borrarPerfil(Model model) {
		int idUsuarioSesion= securityService.obtenerIdUsuarioDeSesion();
		boolean tieneReservasPendientes= clientesService.borrarRegistroCliente(idUsuarioSesion);
		if(tieneReservasPendientes==true) {
			String mensaje="Todavía tienes reservas pendientes";
			model.addAttribute("mensaje", mensaje);
			return "redirect:/miPerfil";
		}
		
		else {
		//Llamo al método para invalidar sesión y así cuando se borra de la base de datos tb se elimina de sesión 
		// y security Service no intenta recuperrarlo de la BD (que no existe y da un error si es así).
		securityService.invalidarSesion();
		return "redirect:/home";
		}
	}
	
	
	@RequestMapping(value="/preguntasFrecuentes", method=RequestMethod.GET)
	public String modalView(Model model) {
		String usuarioSesion= securityService.obtenerUsuarioDeSesion();
		boolean isAnonymousUser;
		if(usuarioSesion!="anonymousUser") {
			isAnonymousUser=false;
		}else {
			isAnonymousUser=true;
		}
		
		model.addAttribute("isAnonymousUser",isAnonymousUser);
		model.addAttribute("usuarioSesion",usuarioSesion);
		
		return "faqs";
	}
	
	//Urls para peticiones ajax
	
	@RequestMapping(value="/comprobarTieneReservas", method=RequestMethod.GET)
	@ResponseBody
	public String MensajeAlert(Model model) {
		  
		  String mensaje=clientesService.crearMensajeReservaPendienteCliente();
			return mensaje;
		}
	

	@RequestMapping(value="/resetearMensajeTieneReservas", method=RequestMethod.GET)
	@ResponseBody
	public void ResetearMensajeTieneReservas(Model model) {
		  
		  clientesService.resetearMensajeTieneReserva();
		
		}
	
	@RequestMapping(value="/confirmarEmailServidor", method=RequestMethod.GET)
	@ResponseBody
	public String confirmarEmailServidor( @RequestParam String email) {
		
		  String mensajeEmail= clientesService.crearMensajeEmailExiste(email);
		  return mensajeEmail;
		
		}
	
	@RequestMapping(value="/confirmarReservaOk", method=RequestMethod.GET)
	@ResponseBody
	public String confirmarReservaOk(Model model) {
		
		  String mensajeREservaOk= reservaService.crearMensajeReservaOk();
		  return mensajeREservaOk;
		
		}
	
	@RequestMapping(value="/resetearMensajeReservaOk", method=RequestMethod.GET)
	@ResponseBody
	public void ResetearMensajeReservaOk(Model model) {
		  
		 reservaService.resetearMensajeReservaOk();
		
		}
	
	
	
}
	
	





