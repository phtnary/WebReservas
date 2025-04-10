package com.webreservas.dao;
import java.util.List;

import com.webreservas.model.Cliente;
import com.webreservas.model.Reserva;
import com.webreservas.model.TipoAventura;

public interface ClienteDao {
	
	List <Cliente> getAllClientes();
	Cliente getClienteById(int id);
	Cliente insertarCliente(Cliente cliente);
	Cliente actualizarCliente(Cliente cliente);
	Cliente getClienteByEmail(String email);
	void borrarRegistroCliente(int idUsuarioSesion);
	
	

}
