package vn.spring.nam.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.mail.MessagingException;
import vn.spring.nam.notification.api.request.OTPRequest;

public interface NotificationService {
    void receiveNotificationFromTopic(String message) throws JsonProcessingException, MessagingException;
}
