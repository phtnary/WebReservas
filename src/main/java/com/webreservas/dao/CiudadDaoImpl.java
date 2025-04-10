package com.webreservas.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.webreservas.model.Ciudad;


@Repository
public class CiudadDaoImpl implements CiudadDao{

	@Autowired
	CiudadJpa ciudadJpa;

	@Override
	public List<Ciudad> getAllCiudades() {
		
		return ciudadJpa.findByOrderByLocalidad();
	}

}

