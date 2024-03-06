package com.example.jobSearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobSearch.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	List<Skill> findAllByUserid(Long id);

}
