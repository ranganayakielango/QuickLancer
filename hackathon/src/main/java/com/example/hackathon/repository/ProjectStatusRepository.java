package com.example.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hackathon.entity.ProjectStatus;

public interface ProjectStatusRepository extends CrudRepository<ProjectStatus,Long>{
	
	 ProjectStatus findByProjectIdAndFreelancerEmail(int projectId, String freelancerEmail);
	 
	  void deleteByProjectIdAndFreelancerEmail(int projectId, String freelancerEmail);

}
