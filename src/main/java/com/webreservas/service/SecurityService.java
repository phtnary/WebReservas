package com.webreservas.service;


public interface SecurityService {
	
	String obtenerUsuarioDeSesion ();
	int obtenerIdUsuarioDeSesion ();
	public void invalidarSesion();
}
