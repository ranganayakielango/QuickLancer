package com.example.hackathon.entity;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String domain;
    private String title;
    private String description;
    private String technology;
    private Integer budget;
    private Boolean negotiateBudget;
    private Boolean negotiateTime;
    public Boolean getNegotiateTime() {
		return negotiateTime;
	}

	public void setNegotiateTime(Boolean negotiateTime) {
		this.negotiateTime = negotiateTime;
	}

	private Float noOfHours;
    private Integer daysLimit;
    private LocalTime comfortTimeFrom;
    private LocalTime comfortTimeTo;
    private String timezone;
    private String clientEmail;
    private Date date;

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	// Constructors
    public Project() {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Boolean getNegotiateBudget() {
        return negotiateBudget;
    }

    public void setNegotiateBudget(Boolean negotiateBudget) {
        this.negotiateBudget = negotiateBudget;
    }

    public Float getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Float noOfHours) {
        this.noOfHours = noOfHours;
    }

    public Integer getDaysLimit() {
        return daysLimit;
    }

    public void setDaysLimit(Integer daysLimit) {
        this.daysLimit = daysLimit;
    }

    public LocalTime getComfortTimeFrom() {
        return comfortTimeFrom;
    }

    public void setComfortTimeFrom(LocalTime comfortTimeFrom) {
        this.comfortTimeFrom = comfortTimeFrom;
    }

    public LocalTime getComfortTimeTo() {
        return comfortTimeTo;
    }

    public void setComfortTimeTo(LocalTime comfortTimeTo) {
        this.comfortTimeTo = comfortTimeTo;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
