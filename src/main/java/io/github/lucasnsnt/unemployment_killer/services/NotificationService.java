package io.github.lucasnsnt.unemployment_killer.services;

import io.github.lucasnsnt.unemployment_killer.model.entity.Job;
import io.github.lucasnsnt.unemployment_killer.model.entity.JobSource;
import io.github.lucasnsnt.unemployment_killer.notification.JobNotificationFormatter;
import io.github.lucasnsnt.unemployment_killer.notification.TelegramNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NotificationService {

    @Autowired
    TelegramNotification telegramNotification;

    public void sendNotification(String notificationText) {

        telegramNotification.sendNotification(notificationText);
    }

}
