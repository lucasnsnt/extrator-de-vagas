package io.github.lucasnsnt.unemployment_killer.scraper;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;

import java.io.IOException;
import java.util.List;

public interface JobScraper {
    List<Job> scrapJob(List<String> keyword) throws IOException;
    String getSourceName();
}
