package io.github.lucasnsnt.unemployment_killer.services;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import io.github.lucasnsnt.unemployment_killer.notification.JobNotificationFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class JobOrchestrator {

    @Autowired
    EnrichmentService enrichmentService;

    @Autowired
    HashService hashService;

    @Autowired
    NormalizationService normalizationService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    PersistenceService persistenceService;

    @Autowired
    JobNotificationFormatter jobNotificationFormatter;

    @Transactional
    public Job processJob(Job job, JobSource jobSource, Set<String> sourceJobFindId) throws Exception {
        String preFormatedTitle = job.getTitle();
        String preFormatedDescription = job.getDescription();


        job.setTitle(normalizationService.normalizationMethod(job.getTitle()));
        job.setDescription(normalizationService.normalizationMethod(job.getDescription()));
        job.setCompany(normalizationService.normalizationMethod(job.getCompany()));

        job.setId(hashService.generateHash(job.getTitle(), job.getDescription(), job.getCompany()));

        Optional<Job> persist = persistenceService.persistJob(job, jobSource, sourceJobFindId);

        if (persist.isPresent()) {

            String forSend = enrichmentService.enrich(
                    jobNotificationFormatter
                            .formatNotification
                                    (job, preFormatedTitle, preFormatedDescription)
            );
            notificationService.sendNotification(forSend);

            return persist.get();
        }

        return null;

    }

}
