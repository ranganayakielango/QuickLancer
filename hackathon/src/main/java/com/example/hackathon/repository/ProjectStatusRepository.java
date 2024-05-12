package com.example.hackathon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.hackathon.entity.ProjectStatus;

public interface ProjectStatusRepository extends CrudRepository<ProjectStatus,Long>{
	
	 List<ProjectStatus> findByProjectIdAndFreelancerEmail(int projectId, String freelancerEmail);
	 
	 List<ProjectStatus> findByProjectIdAndClientEmail(int projectId, String clientEmail);
	 
	  void deleteByProjectIdAndFreelancerEmail(int projectId, String freelancerEmail);

}
