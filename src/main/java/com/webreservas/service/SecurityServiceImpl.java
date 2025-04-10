package com.webreservas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.webreservas.dao.ClienteDao;
import com.webreservas.model.Cliente;


@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	ClienteDao clienteDao;

	
	public String obtenerUsuarioDeSesion () {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		if(currentPrincipalName!="anonymousUser") { 
			Cliente cliente =clienteDao.getClienteByEmail(currentPrincipalName);
			String nombreCliente=cliente.getNombre();  
			return nombreCliente;
		}else {
			return currentPrincipalName;
		}	
	}
	
	public int obtenerIdUsuarioDeSesion () {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		Cliente cliente =clienteDao.getClienteByEmail(currentPrincipalName);
		int idUsuario=cliente.getId_cliente();
		return idUsuario;
	}
	
	public void invalidarSesion() {
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(null);
	}
}

