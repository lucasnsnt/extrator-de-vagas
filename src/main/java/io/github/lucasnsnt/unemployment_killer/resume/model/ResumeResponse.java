package io.github.lucasnsnt.unemployment_killer.resume.model;

import java.util.List;

public class ResumeResponse {
    String profile;
    Skills skills;
    List<Projects> projects;
    List<Projects> professionalExperience;
    List<String> complementaryEducation;


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }

    public List<Projects> getProfessionalExperience() {
        return professionalExperience;
    }

    public void setProfessionalExperience(List<Projects> professionalExperience) {
        this.professionalExperience = professionalExperience;
    }

    public List<String> getComplementaryEducation() {
        return complementaryEducation;
    }

    public void setComplementaryEducation(List<String> complementaryEducation) {
        this.complementaryEducation = complementaryEducation;
    }
}
