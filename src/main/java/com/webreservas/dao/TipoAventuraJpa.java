package com.webreservas.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.webreservas.model.TipoAventura;

public interface TipoAventuraJpa extends JpaRepository<TipoAventura, Integer> {
	TipoAventura findByIdTipo(int id);
	
}
