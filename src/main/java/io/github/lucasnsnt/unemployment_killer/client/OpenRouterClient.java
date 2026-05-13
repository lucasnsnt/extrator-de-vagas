package io.github.lucasnsnt.unemployment_killer.client;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import io.github.lucasnsnt.unemployment_killer.client.request.OpenRouterMessage;
import io.github.lucasnsnt.unemployment_killer.client.request.OpenRouterRequest;
import io.github.lucasnsnt.unemployment_killer.client.response.Choice;
import io.github.lucasnsnt.unemployment_killer.client.response.OpenRouterResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenRouterClient implements IOpenRouterClient {

    private static final String URL = "https://openrouter.ai/api/v1/chat/completions";

    @Value("${llm.api.key}")
    private String llmApiKey;

    @Override
    public String  generateContent ( String text , String prompt) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        List<OpenRouterMessage> messagesList = new ArrayList<>();
        messagesList.add(new OpenRouterMessage("user", prompt + "\n\n" + text));
        OpenRouterRequest requestObject =
                new OpenRouterRequest("~google/gemini-flash-latest", messagesList);
        String json = gson.toJson(requestObject);

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

        try {
            Request request = new Request.Builder()
                    .url(URL)
                    .post(body)
                    .addHeader("Authorization","Bearer " + llmApiKey)
                    .addHeader("Content-Type","application/json")
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                String responsebody = response.body().string();
                OpenRouterResponse responseObject = gson
                        .fromJson(responsebody, OpenRouterResponse.class);
                return responseObject.getChoices().getFirst().getMessage().getContent();

            }
            else  {
                return response.body().string();
            }


        }catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
