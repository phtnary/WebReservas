package com.webreservas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webreservas.model.TipoAventura;

@Repository
public class TipoAventuraDaoImpl implements TipoAventuraDao {
	@Autowired
	TipoAventuraJpa tipoAventuraJpa;

	@Override
	public List<TipoAventura> getAllTiposAventura() {
		
		return tipoAventuraJpa.findAll();
	}

	@Override
	public TipoAventura getTipoAventuraById(int id) {
		return tipoAventuraJpa.findByIdTipo(id);
	}


}
