package io.github.lucasnsnt.unemployment_killer.scraper.gupy;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import io.github.lucasnsnt.unemployment_killer.repository.IJobSourceRepository;
import io.github.lucasnsnt.unemployment_killer.scraper.JobScraper;
import org.springframework.stereotype.Component;


import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class GupyScraper implements JobScraper {

    @Override
    public List<Job> scrapJob(List<String> keyword) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        List<Job> jobs = new ArrayList<>();
        GupyApiResponse gupyApiResponse;

        try {

            for (String keyworditem : keyword) {

                String gupyUrl = "https://employability-portal.gupy.io/api/v1/jobs?jobName=" + keyworditem + "&limit=10&offset=0";

                Request request = new Request.Builder()
                        .url(gupyUrl)
                        .get()
                        .addHeader("accept", "application/json")
                        .build();

                Response response = client.newCall(request).execute();

                if (response.isSuccessful()) {
                    String jsonBody = response.body().string();

                    gupyApiResponse = gson.fromJson(jsonBody, GupyApiResponse.class);

                    for (GupyJobResponse jobResponse : gupyApiResponse.getData()) {
                        if (!"vacancy_type_effective".equals(jobResponse.getType())) {
                            continue;
                        }
                        Job job = new Job();
                        JobSource jobSource = new JobSource();
                        job.setTitle(jobResponse.getName());
                        job.setDescription(jobResponse.getDescription());
                        job.setCompany(jobResponse.getCareerPageName());
                        job.setState(jobResponse.getState());
                        job.setCity(jobResponse.getCity());
                        job.setCountry(jobResponse.getCountry());
                        job.setWorkplaceType(jobResponse.getWorkplaceType());
                        job.setPublishedAt(LocalDate.parse(jobResponse.
                                getPublishedDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")));

                        jobSource.setJob(job);
                        jobSource.setSourceJobId(jobResponse.getId());
                        jobSource.setCompanyPageUrl(jobResponse.getCareerPageUrl());
                        jobSource.setSource("Gupy");
                        jobSource.setUrl(jobResponse.getJobUrl());
                        job.getSources().add(jobSource);
                        jobs.add(job);

                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  jobs;
    }
    @Override
    public String getSourceName() {

        return "Gupy";
    }
}
