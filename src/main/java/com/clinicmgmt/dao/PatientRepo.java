package com.clinicmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.clinicmgmt.model.Patient;

@Component
public interface PatientRepo extends JpaRepository<Patient, String> {

}
