package com.example.jobSearch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobSearch.model.Job;
import com.example.jobSearch.model.Skill;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

	 


}
