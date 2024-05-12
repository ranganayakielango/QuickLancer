package com.example.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackathon.entity.CompletedProject;

@Repository
public interface CompletedProjectRepository extends JpaRepository<CompletedProject, Long> {
    CompletedProject findByProjectIdAndClientIdAndFreelancerid(int projectId, String clientId, String freelancerId);

    List<CompletedProject> findByFreelancerid(String freelancerid);
    
    List<CompletedProject> findByClientId(String ClientId);
}
