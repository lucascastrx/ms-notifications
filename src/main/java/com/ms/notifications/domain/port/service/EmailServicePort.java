package com.ms.notifications.domain.port.service;

import com.ms.notifications.domain.model.Email;
import org.springframework.transaction.annotation.Transactional;

public interface EmailServicePort {
    @Transactional
    Email sendEmail(Email email);
}
