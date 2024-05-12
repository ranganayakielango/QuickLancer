package com.example.hackathon.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "completedproject")
public class CompletedProject {

    @Id
    @Column(name = "projectid")
    private int projectId;

    @Column(name = "clientid")
    private String clientId;
    
    @Column(name = "freelancerid")
    private String freelancerid;

    public String getFreelancerid() {
		return freelancerid;
	}

	public void setFreelancerid(String freelancerid) {
		this.freelancerid = freelancerid;
	}

	@Column(name = "clientrating")
    private Float clientrating;
	
	@Column(name = "freelancerrating")
    private Float freelancerrating;

    @Column(name = "clientfeedback", length = 450)
    private String clientfeedback;
    
    @Column(name = "freelancerfeedback", length = 450)
    private String freelancerfeedback;

	public Float getClientrating() {
		return clientrating;
	}

	public void setClientrating(Float clientrating) {
		this.clientrating = clientrating;
	}

	public Float getFreelancerrating() {
		return freelancerrating;
	}

	public void setFreelancerrating(Float freelancerrating) {
		this.freelancerrating = freelancerrating;
	}

	public String getClientfeedback() {
		return clientfeedback;
	}

	public void setClientfeedback(String clientfeedback) {
		this.clientfeedback = clientfeedback;
	}

	public String getFreelancerfeedback() {
		return freelancerfeedback;
	}

	public void setFreelancerfeedback(String freelancerfeedback) {
		this.freelancerfeedback = freelancerfeedback;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Float getRating() {
		return clientrating;
	}

	public void setRating(Float rating) {
		this.clientrating = rating;
	}

	
}
