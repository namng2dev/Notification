package vn.spring.nam.notification.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import vn.spring.nam.notification.api.request.OTPRequest;
import vn.spring.nam.notification.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public EmailServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    @Async
    public void sendMail(OTPRequest request) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setTo(request.getEmail());
        mimeMessageHelper.setSubject("This is verify OTP");

        Context context = new Context();
        context.setVariable("fullName", request.getFullName());
        context.setVariable("otp", request.getOtp());

        String processedString = templateEngine.process("email_verify_otp", context);

        mimeMessageHelper.setText(processedString, true);

        mailSender.send(mimeMessage);
    }
}
