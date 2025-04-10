package com.webreservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.webreservas.controller", 
		"com.webreservas.dao", 
		"com.webreservas.security",
		"com.webreservas.service",
		"com.webreservas"})
@EntityScan(basePackages= {"com.webreservas.model"}) //Packages donde tiene que buscar clases del modelo
@EnableJpaRepositories(basePackages= {"com.webreservas.dao"})
@SpringBootApplication
public class WebReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebReservasApplication.class, args);
	}

}
