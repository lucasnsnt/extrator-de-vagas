package io.github.lucasnsnt.unemployment_killer.notification;

import org.springframework.stereotype.Repository;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Repository
public interface IsendNotification  {

    public void sendNotification(String message);

    public void sendDocument(byte[] documentContent, String documentName);
}
