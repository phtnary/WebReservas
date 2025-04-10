package com.webreservas.dao;

import java.util.List;

import com.webreservas.model.Empresa;

public interface EmpresaDao {
	List <Empresa> getAllEmpresas();
	Empresa getEmpresaById(int id);

}
