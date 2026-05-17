package io.github.lucasnsnt.unemployment_killer.services;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import io.github.lucasnsnt.unemployment_killer.repository.IJobRepository;
import io.github.lucasnsnt.unemployment_killer.repository.IJobSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class PersistenceService {

    @Autowired
    private IJobRepository iJobRepository;

    @Autowired
    private IJobSourceRepository iJobSourceRepository;

    @Transactional
    public Optional<Job> persistJob(Job job, JobSource jobSource, Set<String> sourceJobFindId) throws Exception {

        if (iJobRepository.findById(job.getId()).isPresent()) {
            Job existingJob = iJobRepository.findById(job.getId()).get();
            System.out.println("Verificando source: job=" + job.getId() + " source=" +
                    jobSource.getSource() + " url=" + jobSource.getUrl());
            if (iJobSourceRepository.findByJobAndSourceAndUrl
                    (existingJob, jobSource.getSource(), jobSource.getUrl()).isEmpty()) {

                if (!sourceJobFindId.contains(jobSource.getSourceJobId())) {
                    sourceJobFindId.add(jobSource.getSourceJobId());
                    jobSource.setJob(existingJob);
                    iJobSourceRepository.save(jobSource);
                    return Optional.of(job);
                }
            }
            return Optional.empty();
        }
        Job savedJob = iJobRepository.save(job);
        iJobRepository.flush();
        return Optional.of(savedJob);


    }

}
