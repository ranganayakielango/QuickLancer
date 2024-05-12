package com.example.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathon.entity.CompletedProject;
import com.example.hackathon.entity.Project;
import com.example.hackathon.entity.ProjectStatus;
import com.example.hackathon.service.ProjectService;
import com.example.hackathon.service.ProjectStatusService;

@RestController
public class ProjectStatusController {
	@Autowired  
	ProjectStatusService projectStatusService;
	
	@GetMapping("/projectStatus")  
	private List<ProjectStatus> getAllClients()   
	{  
	return projectStatusService.getAllProject();  
	} 
	
	@PostMapping("/projectStatus")  
	public ResponseEntity<String> saveProjectStatus(@RequestParam int projectId, @RequestBody List<String> freelancerEmails) {
        projectStatusService.saveProjectStatus(projectId, freelancerEmails);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
	
	@PostMapping("/projectStatus/client/confirmation")
	public ResponseEntity<String> saveClientConfirmation(@RequestParam int projectId, @RequestBody String freelancerEmail) {
        projectStatusService.saveProjectStatusClientConfirm(projectId, freelancerEmail);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
	
	@PostMapping("/projectStatus/freelancer/confirmation")
	public ResponseEntity<String> saveFreelancerConfirmation(@RequestParam int projectId, @RequestBody String freelancerEmail) {
        projectStatusService.saveProjectStatusFreelancerConfirm(projectId, freelancerEmail);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
	
	 @PostMapping("/completed-project/rating-and-review")
	    public void saveRatingAndReview(@RequestBody CompletedProject request) {
		 projectStatusService.savereview(request);
	    }
	 
	 @GetMapping("/completed-project/rating-and-review")
	 public List<CompletedProject> getRatingAndReview() {
		 return projectStatusService.getreview();
	    }
}
