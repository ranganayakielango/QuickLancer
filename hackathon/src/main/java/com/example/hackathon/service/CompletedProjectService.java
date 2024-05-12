package com.example.hackathon.service;

import java.util.List;

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
	    
	    public List<CompletedProject> getAllReviewsForFreelancer(String freelancerid) {
	        return completedProjectRepository.findByFreelancerid(freelancerid);
	    }
	    
	    public List<CompletedProject> getAllReviewsForClient(String clientid) {
	        return completedProjectRepository.findByClientId(clientid);
	    }
}
