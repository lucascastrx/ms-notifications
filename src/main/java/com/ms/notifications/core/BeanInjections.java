package com.ms.notifications.core;

import com.ms.notifications.domain.adapter.service.EmailService;
import com.ms.notifications.domain.port.repository.EmailRepositoryPort;
import com.ms.notifications.domain.port.service.EmailServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class BeanInjections {

    @Bean
    public EmailServicePort emailService(EmailRepositoryPort emailRepository, JavaMailSender mailSender){
        return new EmailService(emailRepository, mailSender);
    }
}
