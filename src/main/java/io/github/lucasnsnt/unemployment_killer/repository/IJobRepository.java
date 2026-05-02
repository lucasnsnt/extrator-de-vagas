package io.github.lucasnsnt.unemployment_killer.repository;


import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepository extends JpaRepository<Job, String>{
}
