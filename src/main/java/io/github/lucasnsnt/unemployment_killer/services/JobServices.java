package io.github.lucasnsnt.unemployment_killer.services;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.repository.IJobRepository;
import io.github.lucasnsnt.unemployment_killer.repository.IJobSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Service
public class JobServices {

    @Autowired
    private IJobRepository jobRepository;

    @Autowired
    private IJobSourceRepository jobSourceRepository;


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

    private String generateHash(String title, String description, String company) {
        String hash = title + description + company;
        return hash;


    }

    public Job processJob(Job job) {




        return jobRepository.save(job);

    }


}
