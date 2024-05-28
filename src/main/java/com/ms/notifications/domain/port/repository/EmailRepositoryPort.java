package com.ms.notifications.domain.port.repository;

import com.ms.notifications.domain.model.Email;

public interface EmailRepositoryPort {
    Email save(Email email);
}
