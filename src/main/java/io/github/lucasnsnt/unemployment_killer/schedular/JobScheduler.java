package io.github.lucasnsnt.unemployment_killer.schedular;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.scraper.gupy.GupyScraper;
import io.github.lucasnsnt.unemployment_killer.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class JobScheduler {

    @Value("#{'${filter.keywords}'.split(',')}")
    private List<String> keywords;

    @Autowired
    private JobServices jobServices;

    @Autowired
    private GupyScraper gupyScraper;

    @Scheduled(fixedDelay = 7200000)
    public void JobSearchSchedule() throws Exception {

        List<Job> jobs = gupyScraper.scrapJob(keywords);
        for (Job job : jobs) {
            jobServices.processJob(job, job.getSources().get(0));
        }

    }
}

