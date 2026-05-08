package io.github.lucasnsnt.unemployment_killer.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.http.HttpClient;


public class TelegramNotification implements IsendNotification {


    @Value("${api.telegram.key}")
    private String telegramApiKey;

    @Value("$id.telegram.channel")
    private String telegramChannel;

    @Override
    public void sendNotification(String message){

        String telegramUrl = "https://api.telegram.org/bot" + telegramChannel + "/sendMessage";


    }
}
