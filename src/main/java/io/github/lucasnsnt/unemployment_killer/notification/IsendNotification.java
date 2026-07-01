package io.github.lucasnsnt.unemployment_killer.notification;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface IsendNotification  {

    public void sendNotification(String message);

    public void sendDocument(byte[] documentContent, String documentName);
}
