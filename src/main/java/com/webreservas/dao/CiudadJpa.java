package com.webreservas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.webreservas.model.Ciudad;
//<Ciudad, String> tipo del objeto y el tipo de id de la clase
public interface CiudadJpa  extends JpaRepository<Ciudad, String> {

	List<Ciudad> findByOrderByLocalidad();
}
