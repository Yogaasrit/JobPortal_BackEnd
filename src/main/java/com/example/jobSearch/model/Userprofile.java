package com.example.jobSearch.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Userprofile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long profileid;
    private Long userid;
    private Date dob;
    private String address;
    private String phone;
    private String degree;
    private String university;
    private double cgpa;
    private int yearofpassing;
    private String interestedfield;
    private String interestedcompany;
    private String certification;
    private int experience;
    private int languagesknown;
    
	
	public Long getProfileid() {
		return profileid;
	}


	public void setProfileid(Long profileid) {
		this.profileid = profileid;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public double getCgpa() {
		return cgpa;
	}


	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public int getYearofpassing() {
		return yearofpassing;
	}


	public void setYearofpassing(int yearofpassing) {
		this.yearofpassing = yearofpassing;
	}


	public String getInterestedfield() {
		return interestedfield;
	}


	public void setInterestedfield(String interestedfield) {
		this.interestedfield = interestedfield;
	}


	public String getInterestedcompany() {
		return interestedcompany;
	}


	public void setInterestedcompany(String interestedcompany) {
		this.interestedcompany = interestedcompany;
	}


	public String getCertification() {
		return certification;
	}


	public void setCertification(String certification) {
		this.certification = certification;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public int getLanguagesknown() {
		return languagesknown;
	}


	public void setLanguagesknown(int languagesknown) {
		this.languagesknown = languagesknown;
	}
	
}
