package com.webreservas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webreservas.model.Cliente;
import com.webreservas.model.TipoAventura;

public interface ClienteJpa extends JpaRepository<Cliente, Integer>{
	Cliente findByIdCliente(int id);
	Cliente findByEmail(String email);
	void deleteByEmail(String usuarioSesion);
	
	
}
