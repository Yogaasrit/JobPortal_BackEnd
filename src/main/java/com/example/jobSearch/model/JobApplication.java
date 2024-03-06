package com.example.jobSearch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class JobApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long applicationid;
	private Long userid;
	private Long jobid;
	private String status;
	
	public Long getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(Long applicationid) {
		this.applicationid = applicationid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getJobid() {
		return jobid;
	}
	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
