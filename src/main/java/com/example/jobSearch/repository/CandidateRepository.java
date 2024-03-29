package com.example.jobSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobSearch.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>{
	Candidate findByUseremail(String useremail);
}
