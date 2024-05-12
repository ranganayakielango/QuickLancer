package com.example.hackathon.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

	public List<Project> getAllActiveProjects() {
	    List<Project> activeProjects = new ArrayList<>();
	    projectRepository.findByDeletedproject(0).forEach(activeProjects::add);
	    return activeProjects;
	}
	
	public Project getProjectById(int id) {
	    return projectRepository.findById(id)
	                            .orElseThrow(() -> new EntityNotFound("Project with ID " + id + " not found"));
	}
	
	public Project save(Project project)   
	{  project.setComfortTimeFrom((LocalTime.parse(project.getComfortTimeFrom().format(formatter),formatter)));
	project.setComfortTimeTo((LocalTime.parse(project.getComfortTimeTo().format(formatter),formatter)));
	project.setDeletedproject(0);
		return projectRepository.save(project);  
	}

	public Project update(Project project) {
		return projectRepository.save(project);
	}

	public Project update(Project project, int clientid) {
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
			existingProject.setClientEmail(project.getClientEmail());

			return projectRepository.save(existingProject);
		} else {
			throw new EntityNotFoundException("Client with ID " + clientid + " not found");
		}
	}

	public String getClientIdByProjectId(int projectId) {
		Project project = projectRepository.findAllById(projectId);

		if (project != null) {
			return project.getClientEmail();
		} else {

			// throw new ProjectNotFoundException("Project with ID " + projectId + " not
			// found");
		}
		return null;
	}
	
	public void updateDeletedProjectById(int projectId) {
        projectRepository.updateDeletedProjectById(projectId, 1);
    }
}
