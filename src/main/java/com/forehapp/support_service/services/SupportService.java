package com.forehapp.support_service.services;

import com.forehapp.support_service.dto.SupportRequestDTO;
import com.forehapp.support_service.utils.Emails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SupportService {

    private final JavaMailSender mailSender;

    public SupportService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Value("${support.email.to}")
    private String supportRecipient;

    @Value("${spring.mail.from:no-reply@forehapp.com}")
    private String from;

    public void handleSupportRequest(SupportRequestDTO request) {
        String html = Emails.supportTicketEmail(request.getName(), request.getEmail(), request.getMessage());

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(supportRecipient);
            helper.setFrom(from);
            helper.setSubject("📩 Soporte recibido de " + request.getName());
            helper.setText(html, true); // true = HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar correo de soporte", e);
        }
    }
}
