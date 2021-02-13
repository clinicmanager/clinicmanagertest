package com.clinicmgmt.main;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/employee").hasRole("ADMIN")
		.antMatchers("/employee/{empid}").hasAnyRole("ADMIN", "DOCTOR", "PHARMACIST", "RECEPTION", "PATHOLOGIST" )
		.antMatchers("/findings/*").hasRole("DOCTOR")
		.antMatchers("/patient").hasRole("RECEPTION")
		.antMatchers("/patients*").hasAnyRole("ADMIN", "DOCTOR", "PHARMACIST", "RECEPTION", "PATHOLOGIST" )
		.antMatchers("/prescription").hasRole("DOCTOR")
		.antMatchers("/prescription*").hasAnyRole("DOCTOR","PHARMACIST", "PATHOLOGIST")
		.antMatchers("/").permitAll()
		.and().formLogin();
		
	}
	
	
}
