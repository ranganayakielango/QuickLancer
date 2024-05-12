package com.example.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackathon.entity.CompletedProject;
import com.example.hackathon.repository.CompletedProjectRepository;

@Service
public class CompletedProjectService {
	 @Autowired
	    private CompletedProjectRepository completedProjectRepository;

	    public CompletedProject save(CompletedProject completedProject) {
	        return completedProjectRepository.save(completedProject);
	    }
}
