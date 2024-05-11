package com.example.hackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

@Entity
public class Freelance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phoneNumber;
    private Date dob;
    private String emailId;
    private Integer experience;
    private String educationDetails;
    private String digitalPreferenceLink;
    private String language;
    private Boolean languageMatch;
    private String selfDescription;
    private Blob photo;
    private Blob resume;
    private String negotiableTime;
    private Integer expSalaryPerHour;
    private String salaryNegotiable;
    private Time preferredWorkTimeFrom;
    private Time preferredWorkTimeTo;
    private String timeZone;
    private String domain;
    private String technology;

    // Constructors
    public Freelance() {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Blob getResume() {
        return resume;
    }

    public void setResume(Blob resume) {
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

    public Time getPreferredWorkTimeFrom() {
        return preferredWorkTimeFrom;
    }

    public void setPreferredWorkTimeFrom(Time preferredWorkTimeFrom) {
        this.preferredWorkTimeFrom = preferredWorkTimeFrom;
    }

    public Time getPreferredWorkTimeTo() {
        return preferredWorkTimeTo;
    }

    public void setPreferredWorkTimeTo(Time preferredWorkTimeTo) {
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
}
