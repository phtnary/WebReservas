package com.webreservas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webreservas.model.Cliente;
@Repository
public class ClienteDaoImpl implements ClienteDao{
	@Autowired
	ClienteJpa clienteJpa;

	@Override
	public List<Cliente> getAllClientes() {
		
		return clienteJpa.findAll();
	}

	@Override
	public Cliente getClienteById(int id) {
		return clienteJpa.findByIdCliente(id);
	}

	@Override
	public Cliente insertarCliente(Cliente cliente) {
		return clienteJpa.save(cliente);
		
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		return clienteJpa.save(cliente);
	}

	@Override
	public Cliente getClienteByEmail(String email) {	
		return clienteJpa.findByEmail(email);
	}

	@Override
	public void borrarRegistroCliente(int idUsuarioSesion) {
		clienteJpa.deleteById(idUsuarioSesion);
		
	}
	

}
