
package io.github.lucasnsnt.unemployment_killer.notification;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.net.http.HttpClient;

@Service
public class TelegramNotification extends TelegramLongPollingBot implements IsendNotification {


    @PostConstruct
    public void registerBot() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(this);
            System.out.println("Bot rodando!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Value("${api.telegram.key}")
    private String telegramApiKey;

    @Value("${id.telegram.channel}")
    private String telegramChannel;

    @Override
    public void onUpdateReceived(Update update) { }

    @Override
    public String getBotUsername() {
        return "@UnemploymentKillerBot";
    }

    @Override
    public String getBotToken() {
        return telegramApiKey;
    }

    @Override
    public void clearWebhook() throws TelegramApiRequestException { }

    @Override
    public void sendNotification(String message){

        SendMessage sm = SendMessage.builder()
                .chatId(telegramChannel) //Who are we sending a message to
                .text(message).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }

    }
}
