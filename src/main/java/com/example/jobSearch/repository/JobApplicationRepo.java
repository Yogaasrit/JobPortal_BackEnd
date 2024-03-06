package com.example.jobSearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobSearch.model.JobApplication;

@Repository
public interface JobApplicationRepo extends JpaRepository<JobApplication, Long>{

	List<JobApplication>findAllByUserid(Long id);
	int countByJobid(Long id);
	List<JobApplication> findAllByJobid(Long id);
	JobApplication findByUserid(Long id);
	
}
