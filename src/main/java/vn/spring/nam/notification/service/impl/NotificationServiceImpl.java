package vn.spring.nam.notification.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import vn.spring.nam.notification.api.request.OTPRequest;
import vn.spring.nam.notification.service.EmailService;
import vn.spring.nam.notification.service.NotificationService;

@Component
public class NotificationServiceImpl implements NotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public NotificationServiceImpl(ObjectMapper objectMapper, EmailService emailService) {
        this.objectMapper = objectMapper;
        this.emailService = emailService;
    }

    @Override
    @KafkaListener(topics = "otp")
    public void receiveNotificationFromTopic(String message) throws JsonProcessingException, MessagingException {
        OTPRequest otpRequest = objectMapper.readValue(message, OTPRequest.class);
        emailService.sendMail(otpRequest);
    }
}
