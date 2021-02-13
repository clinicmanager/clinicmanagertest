package com.clinicmgmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.clinicmgmt.model.Findings;

@Component
public interface FindingsRepo extends JpaRepository<Findings, String>{

	List<Findings> findAllByDrid(String drid);

	List<Findings> findAllByPtid(String ptid);

	List<Findings> findAllByDridAndPtid(String drid, String ptid);

}
