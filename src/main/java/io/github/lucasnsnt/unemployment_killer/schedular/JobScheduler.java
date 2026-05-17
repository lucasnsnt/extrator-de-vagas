package io.github.lucasnsnt.unemployment_killer.schedular;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.scraper.gupy.GupyScraper;
import io.github.lucasnsnt.unemployment_killer.services.JobOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JobScheduler {

    @Value("#{'${filter.keywords}'.split(',')}")
    private List<String> keywords;

    @Autowired
        private JobOrchestrator jobOrchestrator;

    @Autowired
    private GupyScraper gupyScraper;

    @Scheduled(cron = "0 0 */3 * * *")
    public void JobSearchSchedule() throws Exception {

        Set<String> sourceJobFindId = new HashSet<>();

        List<Job> jobs = gupyScraper.scrapJob(keywords);
        for (Job job : jobs) {

            try {
                Job savedJob = jobOrchestrator.processJob(job, job.getSources().getFirst(), sourceJobFindId);
                System.out.println(savedJob);
            }catch (Exception e){
                System.out.println("Erro ao processar vaga: " + job.getTitle() + e.getMessage());
            }

            Thread.sleep(2000);
        }

    }
}

