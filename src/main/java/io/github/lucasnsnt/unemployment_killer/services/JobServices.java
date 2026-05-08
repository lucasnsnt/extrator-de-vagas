package io.github.lucasnsnt.unemployment_killer.services;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import io.github.lucasnsnt.unemployment_killer.repository.IJobRepository;
import io.github.lucasnsnt.unemployment_killer.repository.IJobSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.HashSet;
import java.util.Set;

@Service
public class JobServices {

    @Autowired
    private IJobRepository iJobRepository;

    @Autowired
    private IJobSourceRepository iJobSourceRepository;

    public String normalizationMethod(String text) {

        if (text == null) {
            return null;
        }
        text = text.replace("\u00A0", "").toLowerCase().trim();
        text = text.replace("-" , " ").replace("_" , " ");
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[^a-z0-9 ]+", "");
        text = text.replaceAll("\\s+" ," ");

        return text;
    }

    public void normalizeJob(Job job) {

        job.setTitle(normalizationMethod(job.getTitle()));
        job.setDescription(normalizationMethod(job.getDescription()));
        job.setCompany(normalizationMethod(job.getCompany()));
    }

    private String generateHash(String title, String description, String company) throws Exception {


        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(title.getBytes("utf8"),0,title.length());
        if (description != null) {
            m.update(description.getBytes("utf8"), 0, description.length());
        }
        if (company != null) {
            m.update(company.getBytes("utf8"),0,company.length());
        }
        return new BigInteger(1,m.digest()).toString(16);


    }

    @Transactional
    public Job processJob(Job job, JobSource jobSource, Set<String> sourceJobFindId) throws Exception {
        normalizeJob(job);
        job.setId(generateHash(job.getTitle(),job.getDescription(),job.getCompany()));
        System.out.println(job.getId());

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
                }
            }
            return existingJob;
        } else {
            Job savedJob = iJobRepository.save(job);
            iJobRepository.flush();
            return savedJob;
        }

    }

}

