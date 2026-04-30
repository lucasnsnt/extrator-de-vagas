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
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String source;

    @NotBlank
    @Column(nullable = false)
    private String url;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

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

}
