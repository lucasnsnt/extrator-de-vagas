package io.github.lucasnsnt.unemployment_killer.services;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import io.github.lucasnsnt.unemployment_killer.notification.JobNotificationFormatter;
import io.github.lucasnsnt.unemployment_killer.notification.TelegramNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

@Service
public class NotificationService {

    @Autowired
    TelegramNotification telegramNotification;

    public void sendNotification(String notificationText) {

        telegramNotification.sendNotification(notificationText);
    }

    public void sendDocument(byte[] documentContent, String documentName) {

        telegramNotification.sendDocument(documentContent,  documentName);
    }

}
