package com.example.hackathon.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;



public class ProjectClientInfo {

	@Id
	@Column(name = "client_id")
	private String clientEmail;

	@Id
	@Column(name = "project_id")
	private int projectId;

	@Column(name = "date")
	private Date date;
}
