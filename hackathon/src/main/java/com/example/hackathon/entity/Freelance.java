package com.example.hackathon.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Freelance {

 

    private String name;
    private String phoneNumber;
    private LocalDate dob;
    @Id
    private String emailId;
    private Integer experience;
    private String educationDetails;
    private String digitalPreferenceLink;
    private String language;
    private Boolean languageMatch;
    private String selfDescription;
    private byte[] photo;
    private byte[] resume;
    private String negotiableTime;
    private Integer expSalaryPerHour;
    private String salaryNegotiable;
    private LocalTime preferredWorkTimeFrom;
    private LocalTime preferredWorkTimeTo;
    private String timeZone;
    private String domain;
    private String technology;
    private String projects;

    // Constructors
    public Freelance() {
    }

    // Getters and setters
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate localDateTime) {
        this.dob = localDateTime;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(String educationDetails) {
        this.educationDetails = educationDetails;
    }

    public String getDigitalPreferenceLink() {
        return digitalPreferenceLink;
    }

    public void setDigitalPreferenceLink(String digitalPreferenceLink) {
        this.digitalPreferenceLink = digitalPreferenceLink;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getLanguageMatch() {
        return languageMatch;
    }

    public void setLanguageMatch(Boolean languageMatch) {
        this.languageMatch = languageMatch;
    }

    public String getSelfDescription() {
        return selfDescription;
    }

    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }
    public String getNegotiableTime() {
        return negotiableTime;
    }

    public void setNegotiableTime(String negotiableTime) {
        this.negotiableTime = negotiableTime;
    }

    public Integer getExpSalaryPerHour() {
        return expSalaryPerHour;
    }

    public void setExpSalaryPerHour(Integer expSalaryPerHour) {
        this.expSalaryPerHour = expSalaryPerHour;
    }

    public String getSalaryNegotiable() {
        return salaryNegotiable;
    }

    public void setSalaryNegotiable(String salaryNegotiable) {
        this.salaryNegotiable = salaryNegotiable;
    }

    public LocalTime getPreferredWorkTimeFrom() {
        return preferredWorkTimeFrom;
    }

    public void setPreferredWorkTimeFrom(LocalTime localTime) {
        this.preferredWorkTimeFrom = localTime;
    }

    public LocalTime getPreferredWorkTimeTo() {
        return preferredWorkTimeTo;
    }

    public void setPreferredWorkTimeTo(LocalTime preferredWorkTimeTo) {
        this.preferredWorkTimeTo = preferredWorkTimeTo;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

	public void setProjects(String projects) {
		this.projects = projects;
		
	}
	public String getProjects() {
		return projects;
	}
}
