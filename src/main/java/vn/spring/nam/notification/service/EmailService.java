package vn.spring.nam.notification.service;

import jakarta.mail.MessagingException;
import vn.spring.nam.notification.api.request.OTPRequest;

public interface EmailService {
    void sendMail(OTPRequest request) throws MessagingException;
}
