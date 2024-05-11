package com.example.hackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Time;

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
    private Float noOfHours;
    private Integer daysLimit;
    private Time comfortTimeFrom;
    private Time comfortTimeTo;
    private String timezone;

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

    public Time getComfortTimeFrom() {
        return comfortTimeFrom;
    }

    public void setComfortTimeFrom(Time comfortTimeFrom) {
        this.comfortTimeFrom = comfortTimeFrom;
    }

    public Time getComfortTimeTo() {
        return comfortTimeTo;
    }

    public void setComfortTimeTo(Time comfortTimeTo) {
        this.comfortTimeTo = comfortTimeTo;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
