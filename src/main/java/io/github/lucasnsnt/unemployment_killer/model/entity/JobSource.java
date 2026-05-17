package io.github.lucasnsnt.unemployment_killer.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(
        name = "job_source",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"job_id", "source", "url"})
        }
)
public class JobSource {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @NotBlank
    @Column(name = "source" ,nullable = false)
    private String source;

    @NotBlank
    @Column(name = "url" ,nullable = false, unique = true)
    private String url;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(name = "companyPageUrl")
    private String companyPageUrl;

    @Column(name = "sourceJobId")
    private String sourceJobId;

    @Override
    public String toString() {
        return
                """
                  "id": "%s",
                  "source": "%s",
                  "url": "%s",
                
                """.formatted(getId(), getSource(), getUrl());
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public String getCompanyPageUrl() {
        return companyPageUrl;
    }

    public void setCompanyPageUrl(String companyPageUrl) {
        this.companyPageUrl = companyPageUrl;
    }

    public String getSourceJobId() {
        return sourceJobId;
    }

    public void setSourceJobId(String sourceJobId) {
        this.sourceJobId = sourceJobId;
    }
}
