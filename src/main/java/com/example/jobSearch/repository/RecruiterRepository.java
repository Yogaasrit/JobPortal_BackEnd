package com.example.jobSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobSearch.model.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{
	Recruiter findByemail(String email);
}
