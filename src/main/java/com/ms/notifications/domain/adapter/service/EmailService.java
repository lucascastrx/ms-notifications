package com.ms.notifications.domain.adapter.service;

import com.ms.notifications.domain.model.Email;
import com.ms.notifications.domain.model.StatusEmail;
import com.ms.notifications.domain.port.repository.EmailRepositoryPort;
import com.ms.notifications.domain.port.service.EmailServicePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class EmailService implements EmailServicePort {

    private final EmailRepositoryPort emailRepository;
    private final JavaMailSender mailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;
    public EmailService(EmailRepositoryPort emailRepository, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.mailSender = mailSender;
    }

    @Override @Transactional
    public Email sendEmail(Email email){
        try{
            email.setCreatedAt(LocalDateTime.now());
            email.setEmailFrom(this.emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            mailSender.send(message);

            email.setStatus(StatusEmail.SENT);
        } catch (MailException e){
            email.setStatus(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }
}
