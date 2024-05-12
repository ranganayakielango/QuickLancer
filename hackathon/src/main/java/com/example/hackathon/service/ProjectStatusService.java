package com.example.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackathon.entity.CompletedProject;
import com.example.hackathon.entity.ProjectStatus;
import com.example.hackathon.repository.CompletedProjectRepository;
import com.example.hackathon.repository.ProjectStatusRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectStatusService {

	@Autowired
	ProjectStatusRepository projectStatusRepository;

	@Autowired
	ProjectService projectService;
	@Autowired
	CompletedProjectService completedProjectService;
	
	@Autowired
	CompletedProjectRepository completedProjectRepository;

	public List<ProjectStatus> getAllProject() {

		List<ProjectStatus> project = new ArrayList<ProjectStatus>();
		projectStatusRepository.findAll().forEach(project1 -> project.add(project1));
		return project;
	}

	public void saveProjectStatus(int projectId, List<String> freelancerEmails) {
		for (String freelancerEmail : freelancerEmails) {
			ProjectStatus projectStatus = new ProjectStatus();
			projectStatus.setProjectId(projectId);
			projectStatus.setClientEmail(projectService.getClientIdByProjectId(projectId));
			projectStatus.setFreelancerEmail(freelancerEmail);
			projectStatus.setClientStatus("Pending");
			projectStatus.setFreelancerStatus("Pending");
			projectStatusRepository.save(projectStatus);
		}
	}
	@Transactional
	public void deleteProjectStatus(int projectId, String freelancerEmail) {
		projectStatusRepository.deleteByProjectIdAndFreelancerEmail(projectId, freelancerEmail);
	}
	@Transactional
	public void saveProjectStatusClientConfirm(int projectId, String freelancerEmail) {
		ProjectStatus projectStatus = projectStatusRepository.findByProjectIdAndFreelancerEmail(projectId,
				freelancerEmail);

		if (projectStatus != null) {

			projectStatus.setClientStatus("Confirm");
			System.out.print("\n**helloout"+ " "+projectStatus.getClientStatus());
			
			if("Confirm".equals(projectStatus.getFreelancerStatus())){
				CompletedProject completedProject = new CompletedProject();
				completedProject.setClientId(projectStatus.getClientEmail());
				completedProject.setFreelancerid(freelancerEmail);
				completedProject.setProjectId(projectId);
				System.out.print("\n++hello");
				completedProjectService.save(completedProject);
				deleteProjectStatus(projectId, freelancerEmail);

			} else {
				projectStatusRepository.save(projectStatus);
			}

	}}
	
	

	@Transactional
	public void saveProjectStatusFreelancerConfirm(int projectId, String freelancerEmail) {
		ProjectStatus projectStatus = projectStatusRepository.findByProjectIdAndFreelancerEmail(projectId,
				freelancerEmail);

		if (projectStatus != null) {

			projectStatus.setFreelancerStatus("Confirm");
			System.out.print("helloout"+ " "+projectStatus.getClientStatus());
			if("Confirm".equals(projectStatus.getClientStatus())){
				CompletedProject completedProject = new CompletedProject();
				completedProject.setClientId(projectStatus.getClientEmail());
				completedProject.setFreelancerid(freelancerEmail);
				completedProject.setProjectId(projectId);
				System.out.print("hello");
				completedProjectService.save(completedProject);
				deleteProjectStatus(projectId, freelancerEmail);

			} else {
				projectStatusRepository.save(projectStatus);
			}
		}

	}

	public void savereview(CompletedProject completedProject) {
		CompletedProject completedProject1 = completedProjectRepository.findByProjectIdAndClientIdAndFreelancerid(completedProject.getProjectId(), completedProject.getClientId(),completedProject.getFreelancerid());
        System.out.print(completedProject.getClientfeedback());
		if (completedProject1 != null && completedProject.getClientrating()!=null) {
            completedProject.setFreelancerrating(completedProject1.getFreelancerrating());
            completedProject.setFreelancerfeedback(completedProject1.getFreelancerfeedback());
            completedProjectRepository.save(completedProject);
        } else if (completedProject1 != null && completedProject.getFreelancerrating()!=null) {
            completedProject.setClientrating(completedProject1.getClientrating());
            completedProject.setClientfeedback(completedProject1.getClientfeedback());
            completedProjectRepository.save(completedProject);
        } 
	}
	
	public List<CompletedProject> getreview() {

		List<CompletedProject> project = new ArrayList<CompletedProject>();
		completedProjectRepository.findAll().forEach(project1 -> project.add(project1));
		return project;
	}

}
