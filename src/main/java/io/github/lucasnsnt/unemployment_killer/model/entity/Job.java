package io.github.lucasnsnt.unemployment_killer.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "id" ,updatable = false)
    private String id;

    @NotBlank
    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "company")
    private String company;

    @Column(name = "location")
    private String location;

    @Lob
    @Column(name = "description" , columnDefinition = "TEXT")
    private String description;

    @Column(name = "publishedAt")
    private LocalDate publishedAt;

    @Column(name = "createdAt" ,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "workplaceType")
    private String workplaceType;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @Column(name = "status")
    private String status;

    @OneToMany(
            mappedBy = "job",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<JobSource> sources = new ArrayList<>();

    @Override
    public String toString() {
        return  """
                {
                  "title": "%s",
                  "id": "%s",
                  "company": "%s",
                  "sources": %s
                }
                """
                .formatted(getTitle(), getId(), getCompany(), getSources()



        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public List<JobSource> getSources() {
        return sources;
    }

    public void setSources(List<JobSource> sources) {
        this.sources = sources;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkplaceType() {
        return workplaceType;
    }

    public void setWorkplaceType(String workplaceType) {
        this.workplaceType = workplaceType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
