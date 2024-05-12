package com.example.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathon.entity.Project;
import com.example.hackathon.service.ProjectService;

@CrossOrigin(origins = { "http://localhost:3000", "https://staging.example.com",
		"https://app.example.com" }, methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.PUT,
				RequestMethod.DELETE, RequestMethod.POST })
@RestController
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@GetMapping("/project")
	private List<Project> getAllClients() {
		return projectService.getAllProject();
	}
	
	@GetMapping("/project/{id}")
	private Project getProject(@PathVariable("id") int id) {
		return projectService.getProjectById(id);
	}

	@PostMapping("/project")
	private String saveProject(@RequestBody Project project) {
		projectService.save(project);
		return "ok";

	}

	@PutMapping("/project")
	private Project update(@RequestBody Project project) {
		projectService.update(project, project.getId());
		return project;
	}

}
