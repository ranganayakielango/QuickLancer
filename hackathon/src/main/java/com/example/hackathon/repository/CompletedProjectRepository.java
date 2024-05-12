package com.example.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackathon.entity.CompletedProject;

@Repository
public interface CompletedProjectRepository extends JpaRepository<CompletedProject, Long> {
    CompletedProject findByProjectIdAndClientIdAndFreelancerid(int projectId, String clientId, String freelancerId);
}
