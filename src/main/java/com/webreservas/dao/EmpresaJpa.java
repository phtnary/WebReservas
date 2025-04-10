package com.webreservas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webreservas.model.Empresa;

public interface EmpresaJpa  extends JpaRepository<Empresa, Integer> {
	Empresa findByIdEmpresa(int id);

}
