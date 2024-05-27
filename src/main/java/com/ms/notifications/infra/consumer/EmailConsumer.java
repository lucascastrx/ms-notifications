package com.ms.notifications.infra.consumer;

import com.ms.notifications.api.dto.email.input.EmailDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO string){
        System.out.println(string);
    }
}
