package com.example.hackathon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackathon.entity.Project;
import com.example.hackathon.repository.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	public List<Project> getAllProject() {

		List<Project> project = new ArrayList<Project>();
		projectRepository.findAll().forEach(project1 -> project.add(project1));
		return project;
	}
	
	 public Project save(Project project)   
	{  
		return projectRepository.save(project);  
	} 
	 
	 public Project update(Project project)   
		{  
			return projectRepository.save(project);  
		} 
	 
	 public Project update(Project project, int clientid)   
	 {  
		 Optional<Project> optionalProject = projectRepository.findById(clientid);
	        
	        if (optionalProject.isPresent()) {
	            Project existingProject = optionalProject.get();
	            existingProject.setDomain(project.getDomain());
	            existingProject.setTitle(project.getTitle());
	            
	            existingProject.setBudget(project.getBudget());
	            existingProject.setComfortTimeFrom(project.getComfortTimeFrom());
	            existingProject.setComfortTimeTo(project.getComfortTimeTo());
	            existingProject.setDaysLimit(project.getDaysLimit());
	            existingProject.setDescription(project.getDescription());
	            existingProject.setNegotiateBudget(project.getNegotiateBudget());
	            existingProject.setNoOfHours(project.getNoOfHours());
	            existingProject.setTechnology(project.getTechnology());
	            existingProject.setTimezone(project.getTimezone());
	            
	            return projectRepository.save(existingProject);
	        } else {
	            throw new EntityNotFoundException("Client with ID " + clientid + " not found");
	        }
	    } 
	 }  
	 

