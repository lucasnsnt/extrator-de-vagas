package io.github.lucasnsnt.unemployment_killer.client.response;

public class Choice {
    String finish_reason;
    Message message;

    public String getFinish_reason() {
        return finish_reason;
    }

    public Message getMessage() {
        return message;
    }
}
