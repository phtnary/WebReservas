package com.webreservas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.webreservas.dao.ClienteDao;
import com.webreservas.model.Cliente;

public class BDDetalleUsuarioService implements UserDetailsService{
	
	@Autowired
	private ClienteDao clienteDao;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Cliente cliente = clienteDao.getClienteByEmail(username);

		if (cliente == null) {
            throw new UsernameNotFoundException("Este ususario no existe");
        }
         
        return new DetalleUsuario(cliente);


	}

}
