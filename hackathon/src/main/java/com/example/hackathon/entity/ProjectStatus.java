package com.example.hackathon.entity;

import jakarta.persistence.*;


@Entity
@IdClass(ProjectKey.class)
@Table(name = "projectstatus")
public class ProjectStatus {

    @Id
    @Column(name = "projectid")
    private int projectId;

    @Id
    @Column(name = "clientemail")
    private String clientEmail;
    
    @Id
    @Column(name = "frelanceremail")
    private String freelancerEmail;

    @Column(name = "clientstaus")
    private String clientStatus;

    @Column(name = "freelancerstatus")
    private String freelancerStatus;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getFreelancerEmail() {
		return freelancerEmail;
	}

	public void setFreelancerEmail(String freelancerEmail) {
		this.freelancerEmail = freelancerEmail;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public String getFreelancerStatus() {
		return freelancerStatus;
	}

	public void setFreelancerStatus(String freelancerStatus) {
		this.freelancerStatus = freelancerStatus;
	}
}
