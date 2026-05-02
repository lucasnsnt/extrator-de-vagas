package io.github.lucasnsnt.unemployment_killer.repository;

import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobSourceRepository extends JpaRepository<JobSource, String> {
}
