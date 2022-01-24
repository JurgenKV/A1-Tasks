package com.example.task3;

import java.util.List;


public class Login {

    private String application;
    private String appAccountName;
    private String isActive;
    private String jobTitle;
    private String department;

    public Login() {
        application = "";
        appAccountName = "";
        isActive = "";
        jobTitle = "";
        department = "";
    }

    public Login(String _application, String _appAccountName, String _isActive, String _jobTitle, String _department) {
        application = _application;
        appAccountName = _appAccountName;
        isActive = _isActive;
        jobTitle = _jobTitle;
        department = _department;
    }

    public String getApplication() {
        return application;
    }

    public String getAppAccountName() {
        return appAccountName;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setAppAccountName(String appAccountName) {
        this.appAccountName = appAccountName;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Login> parseLoginsData(String path) throws Exception {
        CSVParser csv = new CSVParser();
        List<Login> list = csv.readLogin(path);
        return list;
    }

}
