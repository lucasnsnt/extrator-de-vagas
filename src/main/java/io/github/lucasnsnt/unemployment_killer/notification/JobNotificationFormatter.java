package io.github.lucasnsnt.unemployment_killer.notification;


import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import io.github.lucasnsnt.unemployment_killer.repository.IJobRepository;
import io.github.lucasnsnt.unemployment_killer.repository.IJobSourceRepository;
import io.github.lucasnsnt.unemployment_killer.services.JobServices;
import org.hibernate.mapping.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobNotificationFormatter {

    public String formatNotification(Job job, String preFormatedTitle ,String preFormatedDescription) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<String> urlsJobSource = job.getSources().stream()
                .map(jobSource -> jobSource.getUrl())
                .distinct()
                .toList();

        return String.format("""

                %s

                %s

                %s
                %s %s , %s

                Fonte(s): %s

                """,preFormatedTitle,
                preFormatedDescription.substring(0, Math.min(preFormatedDescription.length(), 4090))
                , job.getPublishedAt().format(dateFormat),job.getState()
                ,job.getCountry(),job.getWorkplaceType(),String.join(" / ", urlsJobSource));
    }
}
