package io.github.lucasnsnt.unemployment_killer.client.request;

public class OpenRouterMessage {
    String role;
    String content;

    public OpenRouterMessage(String user, String prompt) {
        this.role = user;
        this.content = prompt;
    }
}
