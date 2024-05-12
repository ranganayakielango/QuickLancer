package com.example.hackathon.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class ProjectKey implements Serializable {
    private String clientEmail;
    private int projectId;
    public String getFreelancerEmail() {
		return freelancerEmail;
	}

	public void setFreelancerEmail(String freelancerEmail) {
		this.freelancerEmail = freelancerEmail;
	}

	private String freelancerEmail;

    public ProjectKey() {
    }

    public ProjectKey(String clientId, int projectId) {
        this.clientEmail = clientId;
        this.projectId = projectId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientId) {
        this.clientEmail = clientId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectKey that = (ProjectKey) o;
        return Objects.equals(clientEmail, that.clientEmail) &&
                Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientEmail, projectId);
    }
}
