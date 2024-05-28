package com.ms.notifications.infra.adapter.repository;

import com.ms.notifications.api.assembler.Mapper;
import com.ms.notifications.domain.model.Email;
import com.ms.notifications.domain.port.repository.EmailRepositoryPort;
import com.ms.notifications.infra.adapter.model.EmailModel;
import org.springframework.stereotype.Component;

@Component
public class EmailRepository implements EmailRepositoryPort {

    private final EmailRepositoryAccess emailRepositoryAccess;
    private final Mapper mapper;

    public EmailRepository(EmailRepositoryAccess emailRepositoryAccess, Mapper mapper) {
        this.emailRepositoryAccess = emailRepositoryAccess;
        this.mapper = mapper;
    }

    @Override
    public Email save(Email email){
        var emailModel = mapper.transform(email, EmailModel.class);
        emailModel = emailRepositoryAccess.save(emailModel);
        email = mapper.transform(emailModel, Email.class);
        return email;
    }
}
