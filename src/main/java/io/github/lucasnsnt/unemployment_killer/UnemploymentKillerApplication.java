package io.github.lucasnsnt.unemployment_killer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.http.HttpClientName;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Duration;

@SpringBootApplication
@EnableScheduling
public class UnemploymentKillerApplication {

	public static void main(String[] args) throws IOException
	{SpringApplication.run(UnemploymentKillerApplication.class, args);






//		String gupyUrl = "https://fcamara.gupy.io/job/eyJqb2JJZCI6MTExOTUwOTUsInNvdXJjZSI6Imd1cHlfcG9ydGFsIn0=?jobBoardSource=gupy_portal";
//		Document document = Jsoup.connect(gupyUrl)
//				.followRedirects(true)
//				.userAgent("Mozilla/5.0")
//				.get();
//		Element script = document.selectFirst("#__NEXT_DATA__");
//		if (script == null) {
//			throw new RuntimeException("Não encontrou __NEXT_DATA__. HTML pode estar diferente ou bloqueado.");
//		}
//        String json = script.html();
//
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode root = mapper.readTree(json);
//
//		JsonNode job = root
//				.path("props")
//				.path("pageProps")
//				.path("job");
//
//		String title = job.path("name").asText();
//		String description = job.path("description").asText();
//		String requirements = job.path("prerequisites").asText();
//		String responsabilities = job.path("responsibilities").asText();
//		String date = job.path("publishedAt").asText();
//
//		System.out.println(job.toPrettyString());
    }

}
