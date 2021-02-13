package com.clinicmgmt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.clinicmgmt.utility.IdGenerator;

@Entity
public class Patient {
	
	@Id
	private String ptid;
	
	private String ptname;
	
	private Date ptdob;
	private char ptgender;
	
	private long ptphno;
	
	@CreationTimestamp
	private Date created = new Date();
	@UpdateTimestamp
	private Date updated = new Date();
	
	private String role = "patient";
	
	public String getId() {
		return ptid;
	}
	public void setId() {
		this.ptid = IdGenerator.generatePatientId();
	}
	public String getPtname() {
		return ptname;
	}
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}
	public Date getPtdob() {
		return ptdob;
	}
	public void setPtdob(Date ptdob) {
		this.ptdob = ptdob;
	}
	public char getPtgender() {
		return ptgender;
	}
	public void setPtgender(char ptgender) {
		this.ptgender = ptgender;
	}
	public long getPtphno() {
		return ptphno;
	}
	public void setPtphno(long ptphno) {
		this.ptphno = ptphno;
	}
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated() {
		this.updated = new Date();
	}
	public Date getCreated() {
		return created;
	}
	public String getRole() {
		return role;
	}
	public void setRole() {
		this.role = "patient";
	}
	

}
