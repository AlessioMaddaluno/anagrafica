package it.alessiomaddaluno.anagrafica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
		"it.alessiomaddaluno.anagrafica.controller",
		"it.alessiomaddaluno.anagrafica.security",
		"it.alessiomaddaluno.anagrafica.service",
		"it.alessiomaddaluno.anagrafica.repository",
		"it.alessiomaddaluno.anagrafica.common.exception"})
@EntityScan(basePackages = {"it.alessiomaddaluno.anagrafica.model"})
public class AnagraficaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnagraficaApplication.class, args);
	}

}
