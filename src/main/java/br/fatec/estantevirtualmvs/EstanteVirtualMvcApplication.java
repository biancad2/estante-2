package br.fatec.estantevirtualmvs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "br.fatec.estantevirtualmvs.model" })
@EnableJpaRepositories(basePackages = { "br.fatec.estantevirtualmvs.repository" })
@ComponentScan(basePackages = {"br.fatec.estantevirtualmvs.controller" })

public class EstanteVirtualMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstanteVirtualMvcApplication.class, args);
	}

}
