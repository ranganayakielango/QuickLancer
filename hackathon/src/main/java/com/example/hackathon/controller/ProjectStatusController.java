package com.example.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathon.entity.CompletedProject;
import com.example.hackathon.entity.Project;
import com.example.hackathon.entity.ProjectStatus;
import com.example.hackathon.repository.CompletedProjectRepository;
import com.example.hackathon.service.CompletedProjectService;
import com.example.hackathon.service.ProjectService;
import com.example.hackathon.service.ProjectStatusService;

@RestController
public class ProjectStatusController {
	@Autowired  
	ProjectStatusService projectStatusService;
	
	@Autowired
	CompletedProjectService completedProjectService;
	
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
	
	@PostMapping("/projectStatus/client/active")
	public ResponseEntity<String> saveClientActive(@RequestParam int projectId, @RequestBody String freelancerEmail) {
        projectStatusService.saveProjectStatusClientActive(projectId, freelancerEmail);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
	
	@PostMapping("/projectStatus/freelancer/active")
	public ResponseEntity<String> saveFreelancerActive(@RequestParam int projectId, @RequestBody String freelancerEmail) {
        projectStatusService.saveProjectStatusfreelancerActive(projectId, freelancerEmail);
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
	 @GetMapping("/completed-project/rating-and-review/freelancer/{id}")
	 public List<CompletedProject> getAllReviewsForFreelancer(@PathVariable("id") String id) {
		 return completedProjectService.getAllReviewsForFreelancer(id);
	    }
	 @GetMapping("/completed-project/rating-and-review/client/{id}")
	 public List<CompletedProject> getAllReviewsForClient(@PathVariable("id") String id) {
		 return completedProjectService.getAllReviewsForClient(id);
	    }
	 
	 //@GetMapping("/projects/ongoing/{id}")
	 //public List<Project> getAllOngoingProjects(@PathVariable("id") String id) {
		// return completedProjectService.getAllOngoingProjects(id);
	   // }
	 
}
