package com.example.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.hackathon.entity.Project;

import jakarta.transaction.Transactional;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

	Project findAllById(int projectId);

	List<Project> findByDeletedproject(int deletedproject);

	@Transactional
	@Modifying
	@Query("UPDATE Project p SET p.deletedproject = :deleted WHERE p.id = :projectId")
	void updateDeletedProjectById(int projectId, int deleted);

}
