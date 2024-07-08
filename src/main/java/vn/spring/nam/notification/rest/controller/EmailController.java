package vn.spring.nam.notification.rest.controller;
import jakarta.mail.MessagingException;

import org.springframework.web.bind.annotation.RestController;
import vn.spring.nam.notification.api.request.OTPRequest;
import vn.spring.nam.notification.rest.api.EmailApi;
import vn.spring.nam.notification.service.EmailService;

@RestController
public class EmailController implements EmailApi {
    private final EmailService emailingService;

    public EmailController(EmailService emailingService) {
        this.emailingService = emailingService;
    }

    @Override
    public void sendMail(OTPRequest request) throws MessagingException {
        emailingService.sendMail(request);
    }
}