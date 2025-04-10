package com.webreservas.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.webreservas.model.Cliente;

public class DetalleUsuario implements UserDetails {
	
	private Cliente cliente;

	
	public DetalleUsuario(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public String getPassword() {
		
		return cliente.getPassword();
	}

	@Override
	public String getUsername() {
		
		return cliente.getEmail();
	}

}
