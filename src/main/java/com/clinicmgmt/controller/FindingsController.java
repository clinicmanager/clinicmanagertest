package com.clinicmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinicmgmt.dao.FindingsRepo;
import com.clinicmgmt.model.Findings;

@RestController
public class FindingsController {

	@Autowired
	FindingsRepo repo;
	
	@PostMapping(value = "/findings", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Findings addFinding(@RequestBody Findings findings) {
		
		findings.setId();
		
		repo.save(findings);
		System.out.println(findings);
		System.out.println("Findings has been saved");
		
		return findings;
	}
	
	@GetMapping("/findings/doctor/{drid}")
	@ResponseBody
	public List<Findings> getFindingsByDoctor(@PathVariable("drid") String drid) {
		return repo.findAllByDrid(drid);
	}
	
	@GetMapping("/findings/patient/{ptid}")
	@ResponseBody
	public List<Findings> getFindingsByPatient(@PathVariable("ptid") String ptid) {
		return repo.findAllByPtid(ptid);
	}
	
	@GetMapping("/findings/doctor/{drid}/patient/{ptid}")
	@ResponseBody
	public List<Findings> getFindingsByDoctorAndPatient(@PathVariable("drid") String drid, @PathVariable("ptid") String ptid) {
		return repo.findAllByDridAndPtid(drid, ptid);
	}
	
	@PutMapping("/findings/{findingsid}")
	public Findings updateFinding(@PathVariable("findingsid") String findingsid, @RequestBody Findings findings) {
		
		Findings fndg = repo.findById(findingsid).orElseThrow();
		fndg.setFinding1(findings.getFinding1());
		fndg.setFinding2(findings.getFinding2());
		fndg.setFinding3(findings.getFinding3());
		
		repo.save(fndg);
		System.out.println("Findings has been updated");
		
		return findings;
		
	}
	
	
}
