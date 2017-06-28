package br.com.fiap.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import br.com.fiap.configuration.ApplicationConfiguration;

@SpringBootApplication
@ComponentScan({"br.com.fiap.web"})
@Import({ApplicationConfiguration.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
