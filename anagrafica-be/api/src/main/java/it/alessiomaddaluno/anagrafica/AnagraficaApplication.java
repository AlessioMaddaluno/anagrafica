package it.alessiomaddaluno.anagrafica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {
		"it.alessiomaddaluno.anagrafica.controller",
		"it.alessiomaddaluno.anagrafica.security",
		"it.alessiomaddaluno.anagrafica.service",
		"it.alessiomaddaluno.anagrafica.repository",
		"it.alessiomaddaluno.anagrafica.exception",
		"it.alessiomaddaluno.anagrafica.security"})
@EntityScan(basePackages = "it.alessiomaddaluno.anagrafica.model")
public class AnagraficaApplication  extends SpringBootServletInitializer {

	private static Class<AnagraficaApplication> applicationClass = AnagraficaApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(AnagraficaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AnagraficaApplication.class);
	}

}
