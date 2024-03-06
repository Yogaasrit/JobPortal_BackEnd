package com.example.jobSearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jobSearch.model.Userprofile;

@Repository
public interface CandidateProfile extends JpaRepository<Userprofile, Long>{

}
