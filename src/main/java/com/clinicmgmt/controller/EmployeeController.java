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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.clinicmgmt.dao.EmployeeRepo;
import com.clinicmgmt.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo repo;
	
	String oguname;
	int counter = 1;
	
	@RequestMapping("/home")
	public ModelAndView getHome() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
	}
	
	
	@PostMapping(value = "/employee", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Employee addDoctor(@RequestBody Employee employee) {
		
		employee.setEmpid(employee.getRole());
		
		String uname = (employee.getFirstname().charAt(0) + employee.getLastname());
		
		uname.toLowerCase();
		System.out.println("Username lowered cased" + uname);
		oguname=uname;
		oguname.toLowerCase();
		
		String settobeuname = unameexists(uname , employee);
		
		System.out.println("Setting employee username :" + settobeuname);
		//employee.setUsername(settobeuname);
		
		repo.save(employee);
		System.out.println(employee.toString());
		System.out.println("Employee has been saved");
		
		return employee;
	}
	
	
	@GetMapping("/employee")
	@ResponseBody
	public List<Employee> getEmployees() {
		return repo.findAll();
	}
	
	@GetMapping("/employee/{empid}")
	@ResponseBody
	public Optional<Employee> getEmployee(@PathVariable("empid") String empid) {
		System.out.println(empid);
		return repo.findById(empid);
	}
	
	@PutMapping("/employee/{empid}")
	public Employee updateDoctor(@PathVariable("empid") String empid, @RequestBody Employee employee) {
		
		Employee updatedemp = repo.findById(empid).orElseThrow();
		updatedemp.setFirstname(employee.getFirstname());
		updatedemp.setLastname(employee.getLastname());
		updatedemp.setUsername(employee.getUsername());
		updatedemp.setPhoneno(employee.getPhoneno());
		updatedemp.setPassword(employee.getPassword());
		updatedemp.setRole(employee.getRole());
		updatedemp.setEmailaddr(employee.getEmailaddr());				
		repo.save(updatedemp);
		System.out.println("Employee has been updated");
		
		return employee;
	}
	
	@DeleteMapping("/employee/{empid}")
	public String deleteDoctor(@PathVariable("empid") String empid) {
		System.out.println(empid);
		 repo.deleteById(empid);
		 
		 System.out.println("Employee deleted");
			return "Employee Deleted";
	}

	private String unameexists(String uname , Employee employee) {
		
			
			String updateduname = uname;
			
		System.out.println("Username before check : " + uname);
		if(!repo.findByUsername(uname).isEmpty()) {
			
			String tempuname = oguname + counter;
			counter++;
			System.out.println("Username after counter : " + tempuname);
			updateduname = tempuname;
			unameexists(tempuname, employee);
		}
		else {
			counter=1;
			updateduname.toLowerCase();
			System.out.println("returning username for setting : " + updateduname);
			employee.setUsername(updateduname);
			return updateduname;
		}
		
		return null;

		
		
	}
}
