package com.webreservas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webreservas.dao.CiudadDao;
import com.webreservas.model.Ciudad;

@Service
public class CiudadesServiceImpl implements CiudadesService {
	@Autowired
	 CiudadDao ciudadDao;

	@Override
	public List<Ciudad> ObtenerCiudades() {
		
		 return ciudadDao.getAllCiudades();
	}

}
