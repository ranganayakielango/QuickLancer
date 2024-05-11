package com.example.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathon.entity.Project;
import com.example.hackathon.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired  
	ProjectService projectService;
	
	@GetMapping("/project")  
	private List<Project> getAllClients()   
	{  
	return projectService.getAllProject();  
	} 
	
	@PostMapping("/project")  
	private void saveBook(@RequestBody Project client)   
	{ 
	projectService.save(client);
	            
	} 
	@PutMapping("/project")  
	private Project update(@RequestBody Project client)   
	{  
		projectService.update(client, client.getId());  
	return client;  
	}  

}
