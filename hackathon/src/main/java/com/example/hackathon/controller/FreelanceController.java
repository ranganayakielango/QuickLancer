package com.example.hackathon.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.hackathon.entity.Freelance;
import com.example.hackathon.service.FreelanceService;

@CrossOrigin(origins = { "http://localhost:3000", "https://staging.example.com",
"https://app.example.com" }, methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.POST })
@RestController
public class FreelanceController {
	@Autowired
	FreelanceService freelanceService;

	@GetMapping("/freelance")
	private List<Freelance> getAllClients() {
		return freelanceService.getAll();
	}
	@GetMapping("/freelance/{freelancerid}")
	 public Freelance getAllReviewsForFreelancer(@PathVariable("freelancerid")  String freelancerid) {
	        return freelanceService.getByEmailId(freelancerid);
	    }

	@PostMapping("/freelance")
	private String saveBook(@RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("dob") String dob,
            @RequestParam("emailId") String emailId,
            @RequestParam("experience") Integer experience,
            @RequestParam("educationDetails") String educationDetails,
            @RequestParam(required = false) String digitalPreferenceLink,
            @RequestParam("language") String language,
            @RequestParam("languageMatch") Boolean languageMatch,
            @RequestParam("selfDescription") String selfDescription,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam(required = false) MultipartFile resume,
            @RequestParam("negotiableTime") String negotiableTime,
            @RequestParam("expSalaryPerHour") Integer expSalaryPerHour,
            @RequestParam("salaryNegotiable") String salaryNegotiable,
            @RequestParam("preferredWorkTimeFrom") String preferredWorkTimeFrom,
            @RequestParam("preferredWorkTimeTo") String preferredWorkTimeTo,
            @RequestParam("timeZone") String timeZone,
            @RequestParam("domain") String domain,
            @RequestParam("technology") String technology,
            @RequestParam("projects") String projects) throws IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
		Freelance freelancer = new Freelance();
        freelancer.setName(name);
        freelancer.setPhoneNumber(phoneNumber);
        freelancer.setDob(LocalDate.parse(dob));
        freelancer.setEmailId(emailId);
        freelancer.setExperience(experience);
        freelancer.setEducationDetails(educationDetails);
        freelancer.setDigitalPreferenceLink(digitalPreferenceLink);
        freelancer.setLanguage(language);
        freelancer.setLanguageMatch(languageMatch);
        freelancer.setSelfDescription(selfDescription);
        if (photo != null) {
            freelancer.setPhoto(photo.getBytes());
        }
        
        if (resume != null) {
            freelancer.setResume(resume.getBytes());
        }
        freelancer.setNegotiableTime(negotiableTime);
        freelancer.setExpSalaryPerHour(expSalaryPerHour);
        freelancer.setSalaryNegotiable(salaryNegotiable);
        freelancer.setPreferredWorkTimeFrom(LocalTime.parse(preferredWorkTimeFrom,formatter));
        freelancer.setPreferredWorkTimeTo(LocalTime.parse(preferredWorkTimeTo,formatter));
        freelancer.setTimeZone(timeZone);
        freelancer.setDomain(domain);
        freelancer.setTechnology(technology);
        freelancer.setProjects(projects);
        Freelance savedFreelancer = freelanceService.saveFreelancer(freelancer);
        return "ok";
	}
	
	@PutMapping("/freelance")
	private ResponseEntity<?> updateBook(@RequestParam("name") String name,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("dob") String dob,
            @RequestParam("emailId") String emailId,
            @RequestParam("experience") Integer experience,
            @RequestParam("educationDetails") String educationDetails,
            @RequestParam(required = false) String digitalPreferenceLink,
            @RequestParam("language") String language,
            @RequestParam("languageMatch") Boolean languageMatch,
            @RequestParam("selfDescription") String selfDescription,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam(required = false) MultipartFile resume,
            @RequestParam("negotiableTime") String negotiableTime,
            @RequestParam("expSalaryPerHour") Integer expSalaryPerHour,
            @RequestParam("salaryNegotiable") String salaryNegotiable,
            @RequestParam("preferredWorkTimeFrom") String preferredWorkTimeFrom,
            @RequestParam("preferredWorkTimeTo") String preferredWorkTimeTo,
            @RequestParam("timeZone") String timeZone,
            @RequestParam("domain") String domain,
            @RequestParam("technology") String technology,
            @RequestParam("projects") String projects) throws IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
		Freelance freelancer = new Freelance();
        freelancer.setName(name);
        freelancer.setPhoneNumber(phoneNumber);
        freelancer.setDob(LocalDate.parse(dob));
        freelancer.setEmailId(emailId);
        freelancer.setExperience(experience);
        freelancer.setEducationDetails(educationDetails);
        freelancer.setDigitalPreferenceLink(digitalPreferenceLink);
        freelancer.setLanguage(language);
        freelancer.setLanguageMatch(languageMatch);
        freelancer.setSelfDescription(selfDescription);
        if (photo != null) {
            freelancer.setPhoto(photo.getBytes());
        }
        
        if (resume != null) {
            freelancer.setResume(resume.getBytes());
        }
        freelancer.setNegotiableTime(negotiableTime);
        freelancer.setExpSalaryPerHour(expSalaryPerHour);
        freelancer.setSalaryNegotiable(salaryNegotiable);
        freelancer.setPreferredWorkTimeFrom(LocalTime.parse(preferredWorkTimeFrom,formatter));
        freelancer.setPreferredWorkTimeTo(LocalTime.parse(preferredWorkTimeTo,formatter));
        freelancer.setTimeZone(timeZone);
        freelancer.setDomain(domain);
        freelancer.setTechnology(technology);
        freelancer.setProjects(projects);
        Freelance savedFreelancer = freelanceService.update(freelancer);
        return new ResponseEntity<>(savedFreelancer, HttpStatus.CREATED);
	}

}
