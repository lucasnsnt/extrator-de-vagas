package io.github.lucasnsnt.unemployment_killer.client.response;

import java.util.ArrayList;
import java.util.List;

public class OpenRouterResponse {
    List<Choice> choices = new ArrayList<>();

    public List<Choice> getChoices() {
        return choices;
    }
}
