package com.clinicmgmt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.clinicmgmt.utility.IdGenerator;

@Entity
public class Findings {
	
	@Id
	public String id;
	
	private String finding1;
	private String finding2;
	private String finding3;
	
	private String ptid;
	private String drid;
	
	@CreationTimestamp
	private Date created = new Date();
	@UpdateTimestamp
	private Date updated = new Date();
	
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated() {
		this.updated = new Date();
	}
	public Date getCreated() {
		return created;
	}
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getDrid() {
		return drid;
	}
	public void setDrid(String drid) {
		this.drid = drid;
	}
	public String getId() {
		return id;
	}
	public void setId() {
		this.id = IdGenerator.generateFindingsId();
	}
	public String getFinding1() {
		return finding1;
	}
	public void setFinding1(String finding1) {
		this.finding1 = finding1;
	}
	public String getFinding2() {
		return finding2;
	}
	public void setFinding2(String finding2) {
		this.finding2 = finding2;
	}
	public String getFinding3() {
		return finding3;
	}
	public void setFinding3(String finding3) {
		this.finding3 = finding3;
	}
	
	
	
}
