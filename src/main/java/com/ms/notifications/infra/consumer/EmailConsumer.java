package com.ms.notifications.infra.consumer;

import com.ms.notifications.api.assembler.Mapper;
import com.ms.notifications.api.dto.email.input.EmailDTO;
import com.ms.notifications.domain.model.Email;
import com.ms.notifications.domain.port.service.EmailServicePort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    private final Mapper mapper;
    private final EmailServicePort emailService;

    public EmailConsumer(Mapper mapper, EmailServicePort emailService) {
        this.mapper = mapper;
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO){
        System.out.println(emailDTO.emailTo());
        var email = mapper.transform(emailDTO, Email.class);
        email = emailService.sendEmail(email);
    }
}
