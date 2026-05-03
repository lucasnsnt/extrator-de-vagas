package io.github.lucasnsnt.unemployment_killer.repository;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IJobSourceRepository extends JpaRepository<JobSource, String> {

    Optional<JobSource> findByJobAndSourceAndUrl(Job job, String source, String url);
}
