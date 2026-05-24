package io.github.lucasnsnt.unemployment_killer.resume;

import com.google.gson.Gson;
import io.github.lucasnsnt.unemployment_killer.client.OpenRouterClient;
import io.github.lucasnsnt.unemployment_killer.resume.model.ResumeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class ResumeService {


    @Value("classpath:templates/curriculo.html")
    private Resource resource;

    @Autowired
    private OpenRouterClient openRouterClient;


    public String resumeReader () throws Exception {
        try (InputStreamReader reader = new InputStreamReader(
                this.resource.getInputStream(),
                StandardCharsets.UTF_8))
        {
            return FileCopyUtils.copyToString(reader);

        } catch (IOException e) {
            throw new Exception("Error reading file", e);
        }
    }

    public ResumeResponse resumeGenerate(String description) throws IOException {

        String prompt = "a";

        Gson gson = new Gson();

        String jsonRetornado = openRouterClient.generateContent(description, prompt);

        return gson.fromJson(jsonRetornado, ResumeResponse.class);

    }

}
