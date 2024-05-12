package com.example.hackathon.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackathon.entity.Freelance;
import com.example.hackathon.repository.FreelanceRepository;

@Service
public class FreelanceService {
	@Autowired
	FreelanceRepository freelanceRepository;

	public List<Freelance> getAll() {
		List<Freelance> project = new ArrayList<Freelance>();
		freelanceRepository.findAll().forEach(project1 -> project.add(project1));
		return project;
	}

	public Freelance saveFreelancer(Freelance freelance) {
		return freelanceRepository.save(freelance);
	}

	public Freelance update(Freelance freelance) {
		return freelanceRepository.save(freelance);
	}
	
	public Freelance getByEmailId(String email) {
        return freelanceRepository.findByEmailId(email);
    }

}
