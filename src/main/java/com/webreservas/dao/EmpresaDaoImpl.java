package com.webreservas.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webreservas.model.Empresa;

@Repository
public class EmpresaDaoImpl implements EmpresaDao {
	@Autowired
	EmpresaJpa empresaJpa;

	@Override
	public List<Empresa> getAllEmpresas() {
		
		return empresaJpa.findAll();
	}

	@Override
	public Empresa getEmpresaById(int id) {
		
		return empresaJpa.findByIdEmpresa(id);
		
	}


}
