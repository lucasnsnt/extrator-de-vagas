package io.github.lucasnsnt.unemployment_killer.scraper.gupy;

import java.time.LocalDate;
import java.util.Date;

public class GupyJobResponse {

    private String name;
    private String description;
    private String id;
    private String careerPageName;
    private String careerPageUrl;
    private String jobUrl;
    private String workplaceType;
    private String publishedDate;
    private String city;
    private String country;
    private String state;
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCareerPageName() {
        return careerPageName;
    }

    public void setCareerPageName(String careerPageName) {
        this.careerPageName = careerPageName;
    }

    public String getCareerPageUrl() {
        return careerPageUrl;
    }

    public void setCareerPageUrl(String careerPageUrl) {
        this.careerPageUrl = careerPageUrl;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public String getWorkplaceType() {
        return workplaceType;
    }

    public void setWorkplaceType(String workplaceType) {
        this.workplaceType = workplaceType;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPublishedDate() {
        return (publishedDate).substring(0, 10);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
