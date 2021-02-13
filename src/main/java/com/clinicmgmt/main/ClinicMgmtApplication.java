package com.clinicmgmt.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.clinicmgmt.controller")
@EntityScan("com.clinicmgmt.model")
@EnableJpaRepositories(basePackages = "com.clinicmgmt.dao")
public class ClinicMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicMgmtApplication.class, args);
	}

}
