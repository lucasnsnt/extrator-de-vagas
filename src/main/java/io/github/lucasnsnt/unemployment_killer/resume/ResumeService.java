package io.github.lucasnsnt.unemployment_killer.resume;

import com.google.gson.Gson;
import io.github.lucasnsnt.unemployment_killer.client.OpenRouterClient;
import io.github.lucasnsnt.unemployment_killer.resume.model.ResumeResponse;
import io.github.lucasnsnt.unemployment_killer.utils.JsonSanitizer;
import io.github.lucasnsnt.unemployment_killer.utils.ResourceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


@Service
public class ResumeService {


    @Autowired
    private OpenRouterClient openRouterClient;

    @Autowired
    private HtmlRender htmlRender;

    @Autowired
    private PdfService pdfService;

    @Value("classpath:resume_prompt.md")
    private Resource promptResource;



    public ResumeResponse resumeGenerate(String description) throws Exception {

        String prompt = ResourceReader.resourceReader(promptResource);


        Gson gson = new Gson();

        String llmRawOutput = openRouterClient.generateContent(prompt, description, "~google/gemini-flash-latest");

        System.out.println(llmRawOutput);
        String jsonContent = JsonSanitizer.jsonSanitizer(llmRawOutput);

        return gson.fromJson(jsonContent, ResumeResponse.class);

    }

    public byte[] generateResumePdf(String description) throws Exception {

        String htmlContent = htmlRender.render(resumeGenerate(description));

        return pdfService.generatePdf(htmlContent);
    }


}
