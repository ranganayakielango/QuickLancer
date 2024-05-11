package com.example.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hackathon.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
	
}
