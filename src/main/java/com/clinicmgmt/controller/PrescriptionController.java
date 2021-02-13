package com.clinicmgmt.controller;

import java.util.List;

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

import com.clinicmgmt.dao.PrescriptionRepo;
import com.clinicmgmt.model.Prescription;

@RestController
public class PrescriptionController {

	@Autowired
	PrescriptionRepo repo;
	
	@PostMapping(value = "/prescription", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Prescription addPrescription(@RequestBody Prescription prescription) {
		
		prescription.setPrid();
		
		repo.save(prescription);
		System.out.println(prescription);
		System.out.println("Prescription has been saved");
		
		return prescription;
	}
	
	@GetMapping("/prescription/doctor/{drid}")
	@ResponseBody
	public List<Prescription> getPrescriptionByDoctor(@PathVariable("drid") String drid) {
		return repo.findAllByDrid(drid);
	}
	
	@GetMapping("/prescription/patient/{ptid}")
	@ResponseBody
	public List<Prescription> getPrescriptionByPatient(@PathVariable("ptid") String ptid) {
		return repo.findAllByPtid(ptid);
	}
	
	@GetMapping("/prescription/doctor/{drid}/patient/{ptid}")
	@ResponseBody
	public List<Prescription> getPrescriptionByDoctorAndPatient(@PathVariable("drid") String drid, @PathVariable("ptid") String ptid) {
		return repo.findAllByDridAndPtid(drid, ptid);
	}
	
	@PutMapping("/prescription/{prid}")
	public Prescription updatePrescription(@PathVariable("prid") String prid, @RequestBody Prescription pres) {
		
		Prescription pr = repo.findById(prid).orElseThrow();
		pr.setPrescription1(pres.getPrescription1());
		pr.setPrescription2(pres.getPrescription2());
		pr.setPrescription3(pres.getPrescription3());
		pr.setType(pres.getType());
						
		repo.save(pr);
		System.out.println("Prescription has been updated");
		
		return pr;
	}
	
	@DeleteMapping("/prescription/{prid}")
	public String deletePrescription(@PathVariable("prid") String prid) {
		System.out.println(prid);
		 repo.deleteById(prid);
		 
		 System.out.println("Prescription deleted");
			return "Prescription Deleted";
	}
	
}
