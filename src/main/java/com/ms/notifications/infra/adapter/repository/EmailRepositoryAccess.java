package com.ms.notifications.infra.adapter.repository;

import com.ms.notifications.infra.adapter.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepositoryAccess extends JpaRepository<EmailModel, Long> {
}
