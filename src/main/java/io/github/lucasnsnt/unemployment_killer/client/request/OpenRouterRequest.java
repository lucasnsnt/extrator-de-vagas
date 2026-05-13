package io.github.lucasnsnt.unemployment_killer.client.request;

import java.util.List;

public class OpenRouterRequest {
    String model;
    List<OpenRouterMessage> messages;

    public OpenRouterRequest(String model, List<OpenRouterMessage> messages) {
        this.model = model;
        this.messages = messages;
    }
}
