package com.example.jobSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobSearch.model.Candidate;
import com.example.jobSearch.model.CandidateLogin;
import com.example.jobSearch.model.Job;
import com.example.jobSearch.model.JobApplication;
import com.example.jobSearch.model.Recruiter;
import com.example.jobSearch.model.RecruiterLogin;
import com.example.jobSearch.model.Skill;
import com.example.jobSearch.model.Userprofile;
import com.example.jobSearch.repository.CandidateProfile;
import com.example.jobSearch.repository.CandidateRepository;
import com.example.jobSearch.repository.JobApplicationRepo;
import com.example.jobSearch.repository.JobRepository;
import com.example.jobSearch.repository.RecruiterRepository;
import com.example.jobSearch.repository.SkillRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin("http://localhost:3000")
@RestController
public class MainController {
	
	@Autowired
	CandidateRepository candidateRepo;
	
	@Autowired
	RecruiterRepository recruiterRepo;
	
	@Autowired
	CandidateProfile candidateProfile;
	
	@Autowired
	SkillRepository skillRepo;
	
	@Autowired
    HttpServletRequest request;
	
	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	JobApplicationRepo jobApplicationRepo;
	
	
	@GetMapping("/AllCandidate")
	public List<Candidate> getAllCandidate(){
		return candidateRepo.findAll();
	}
	
	@PostMapping("/register")
	Candidate newCandidate(@RequestBody Candidate newCandidate) {
		return candidateRepo.save(newCandidate);
	}
	
	@PostMapping("/recruiter-register")
	Recruiter newRecruiter(@RequestBody Recruiter newRecruiter) {
		return recruiterRepo.save(newRecruiter);
	}
	
	@PostMapping("/login")
	public Long validateLogin(@RequestBody CandidateLogin candidateLogin,
			HttpSession session) {
		Candidate candidate = candidateRepo.findByUseremail(candidateLogin.getUseremail());
		if(candidateLogin.getUserpassword().equals(candidate.getUserpassword())) 
			return candidate.getUserid();		
		return 0L;
	}
	
	@PostMapping("/recruiter-login")
	public Long validateRecruiterLogin(@RequestBody RecruiterLogin recruiterLogin) {
		Recruiter recruiter = recruiterRepo.findByemail(recruiterLogin.getEmail());
		if(recruiter.getPassword().equals(recruiterLogin.getPassword()))
			return recruiter.getId();
		return 0L;
	}
	
	@PostMapping("/add-profile")
	public Userprofile AddProfile(@RequestBody Userprofile userProfile) {
		return candidateProfile.save(userProfile);
	}
	
	@PostMapping("/add-skill")
	public Skill addSkill(@RequestBody Skill skill) {
		return skillRepo.save(skill);
	}
	
	@GetMapping("/viewSkillById/{id}")
	public List<Skill> getAllSkillsById(@PathVariable Long id){
		return skillRepo.findAllByUserid(id);
	}
	
	@GetMapping("/viewParticularSkill/{id}")
	public Skill viewParticularSkillByID(@PathVariable Long id) {
		return skillRepo.findById(id).orElseThrow();
	}
	
	@PutMapping("/edit-skill/{id}")
	Skill editSkill(@RequestBody Skill newSkill, @PathVariable Long id) {
		return skillRepo.findById(id).map(skill -> {
			skill.setName(newSkill.getName());
			skill.setLevel(newSkill.getLevel());
			skill.setExperience(newSkill.getExperience());
			skill.setHandson(newSkill.getHandson());		
			return skillRepo.save(skill);
		}).orElseThrow();
	}
	
	@DeleteMapping("/delete-skill/{id}")
	public void deleteSkillById(@PathVariable Long id) {
		skillRepo.deleteById(id);
	}
	
	@PostMapping("/add-job")
	public Job addJob(@RequestBody Job newJob) {
		return jobRepo.save(newJob);
	}
	
	@GetMapping("/view-jobs")
	public List<Job> viewAllJobs(){
		return jobRepo.findAll();
	}
	
	@PostMapping("/apply-job/{userid}/{jobid}")
	public void applyJob(@PathVariable Long userid, @PathVariable Long jobid) {
		JobApplication application = new JobApplication();
        application.setUserid(userid);
        application.setJobid(jobid);
        application.setStatus("Pending");
        jobApplicationRepo.save(application);
	}
	
	@GetMapping("/view-application/{id}")
	public List<JobApplication> viewMyApplication(@PathVariable Long id){
		return jobApplicationRepo.findAllByUserid(id);
	}
	
	@DeleteMapping("/delete-application/{id}")
	public void deleteApplication(@PathVariable Long id) {
		jobApplicationRepo.deleteById(id);
	}
	
	
	@GetMapping("/view-particular-application/{jobid}")
	public Job viewParticularApplication(@PathVariable Long jobid) {
		return jobRepo.findById(jobid).orElseThrow();
	}
	
	@GetMapping("/total-applicants/{id}")
	public int viewTotalApplicants(@PathVariable Long id) {
		return jobApplicationRepo.countByJobid(id);
	}
	
	@GetMapping("/applicants/{id}")
	public List<JobApplication> viewApplicant(@PathVariable Long id) {
		return jobApplicationRepo.findAllByJobid(id);
	}
	
	@GetMapping("/view-profile/{id}")
	public Userprofile viewUserProfile(@PathVariable Long id) {
		return candidateProfile.findById(id).orElseThrow();
	}
	
	@GetMapping("/update-status/{id}")
	public JobApplication viewJobApplication(@PathVariable Long id) {
		JobApplication jobApplication = jobApplicationRepo.findByUserid(id);
		jobApplication.setStatus("shortlisted");
        jobApplicationRepo.save(jobApplication);
		return jobApplication;
	}
	
	@GetMapping("/update-status-reject/{id}")
	public JobApplication handleReject(@PathVariable Long id) {
		JobApplication jobApplication = jobApplicationRepo.findByUserid(id);
		jobApplication.setStatus("Rejected");
        jobApplicationRepo.save(jobApplication);
		return jobApplication;
	}
}
