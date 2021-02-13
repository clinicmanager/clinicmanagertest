package com.clinicmgmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.clinicmgmt.model.Prescription;

@Component
public interface PrescriptionRepo extends JpaRepository<Prescription, String> {

	List<Prescription> findAllByDrid(String drid);

	List<Prescription> findAllByPtid(String ptid);

	List<Prescription> findAllByDridAndPtid(String drid, String ptid);

}
