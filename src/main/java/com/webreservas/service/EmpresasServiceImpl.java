package com.webreservas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webreservas.dao.EmpresaDao;
import com.webreservas.model.Empresa;

@Service
public class EmpresasServiceImpl implements EmpresasService {
	@Autowired
	EmpresaDao empresaDao;

	@Override
	public List<Empresa> getAllEmpresas() {
		
		 return empresaDao.getAllEmpresas();
	}
	


}

