package com.example.task3.entity;

import com.example.task3.Login;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "logins")
public class Logins {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "application")
    private String application;

    @Column(name = "app_account_name")
    private String appAccountName;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "department")
    private String department;

    public Logins() {
    }

    public Logins(String application, String appAccountName, String isActive, String jobTitle, String department) {
        this.id = UUID.randomUUID();
        this.application = application;
        this.appAccountName = appAccountName;
        this.isActive = isActive;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public Logins(Login login) {
        this.id = UUID.randomUUID();
        this.application = login.getApplication();
        this.appAccountName = login.getAppAccountName();
        this.isActive = login.getIsActive();
        this.jobTitle = login.getJobTitle();
        this.department = login.getDepartment();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAppAccountName() {
        return appAccountName;
    }

    public void setAppAccountName(String appAccountName) {
        this.appAccountName = appAccountName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
