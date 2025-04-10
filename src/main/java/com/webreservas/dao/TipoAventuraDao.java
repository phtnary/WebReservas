package com.webreservas.dao;

import java.util.List;

import com.webreservas.model.TipoAventura;

public interface TipoAventuraDao {
	List <TipoAventura> getAllTiposAventura();
	TipoAventura getTipoAventuraById(int id);

}
