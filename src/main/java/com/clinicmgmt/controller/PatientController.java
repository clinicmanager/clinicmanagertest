package com.clinicmgmt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinicmgmt.dao.PatientRepo;
import com.clinicmgmt.model.Patient;

@RestController
public class PatientController {

	@Autowired
	PatientRepo ptrepo;
	
	@PostMapping(value = "/patient", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Patient addPatient(@RequestBody Patient patient) {
		
		patient.setId();
		
		ptrepo.save(patient);
		System.out.println(patient);
		System.out.println("Patient has been saved");
		
		return patient;
	}
	
	@GetMapping("/patients")
	@ResponseBody
	public List<Patient> getPatients() {
		System.out.println("Patient List has been shared");
		return ptrepo.findAll();
	}
	
	@GetMapping("/patient/{ptid}")
	@ResponseBody
	public Optional<Patient> getPatient(@PathVariable("ptid") String ptid) {
		System.out.println(ptid);
		return ptrepo.findById(ptid);
	}
	
	@PutMapping("/patient/{ptid}")
	public Patient updatePatient(@PathVariable("ptid") String ptid, @RequestBody Patient pat) {
				
		Patient pt = ptrepo.findById(ptid).orElseThrow();
		
		pt.setPtdob(pat.getPtdob());
		pt.setPtgender(pat.getPtgender());
		pt.setPtname(pat.getPtname());
		pt.setPtphno(pat.getPtphno());
		
		ptrepo.save(pt);
		System.out.println("Patient has been updated");
		
		return pt;
	}
	
	@DeleteMapping("/patient/{ptid}")
	public String deletePatient(@PathVariable("ptid") String ptid) {
		System.out.println(ptid);
		 ptrepo.deleteById(ptid);
		 
		 System.out.println("Patient deleted");
			return "Patient Deleted";
	}
}
