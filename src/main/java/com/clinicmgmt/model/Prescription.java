package com.clinicmgmt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.clinicmgmt.utility.IdGenerator;

@Entity
public class Prescription {

	@Id
	public String prid;
	
	public String ptid;
	public String drid;
	public String prescription1;
	public String prescription2;
	public String prescription3;
	public Options type;
	public enum Options{
		M, T
	}
	
	@CreationTimestamp
	private Date created = new Date();
	@UpdateTimestamp
	private Date updated = new Date();
	
	public String getPrid() {
		return prid;
	}
	public void setPrid() {
		this.prid = IdGenerator.generatePrescriptionId();
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
	public String getPrescription1() {
		return prescription1;
	}
	public void setPrescription1(String prescription1) {
		this.prescription1 = prescription1;
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
	
	public String getPrescription2() {
		return prescription2;
	}
	public void setPrescription2(String prescription2) {
		this.prescription2 = prescription2;
	}
	public String getPrescription3() {
		return prescription3;
	}
	public void setPrescription3(String prescription3) {
		this.prescription3 = prescription3;
	}
	public Options getType() {
		return type;
	}
	public void setType(Options options) {
		
		switch(options) {
		case M :
					this.type = Options.M;
					break;
		case T : this.type = Options.T;
					break;
		default : System.out.println("Irrelevant option");;
		}
		
	}
	
	
}
