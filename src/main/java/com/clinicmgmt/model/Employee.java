package com.clinicmgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.clinicmgmt.utility.IdGenerator;

@Entity
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String empid;
	private String firstname;
	private String lastname;
	
	@Column(name="username", unique=true)
	private String username;
	
	private String password;
	private String emailaddr;
	private Long phoneno;
	
	@CreationTimestamp
	private Date created = new Date();
	@UpdateTimestamp
	private Date updated = new Date();
	
	private Role role ;
	
	private enum Role{
		DOCTOR, PHARMACIST, RECEPTION, PATHOLOGIST, ADMIN
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
	}
	public Date getUpdated() {
		return updated;
	}
	//@PreUpdate
	public void setUpdated() {
		this.updated = new Date();
	}
	
	public Date getCreated() {
		return created;
	}
	
	public Long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		switch(role) {
		case DOCTOR : this.role = role;
						break;
		case PHARMACIST : this.role = role;
						break;
		case RECEPTION : this.role = role;
						break;
		case PATHOLOGIST : this.role = role;
						break;
		}
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(Role role) {
		
		switch(role) {
		case DOCTOR : this.empid = IdGenerator.generateDoctorId();
						break;
		case PHARMACIST : this.empid = IdGenerator.generatePharmacistId();
						break;
		case RECEPTION : this.empid = IdGenerator.generateReceptionId();
						break;
		case PATHOLOGIST : this.empid = IdGenerator.generatePathologistId();
						break;
		}
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmailaddr(String emailaddr) {
		this.emailaddr = emailaddr;
	}
	public String getEmailaddr() {
		return emailaddr;
	}

	
	
}

