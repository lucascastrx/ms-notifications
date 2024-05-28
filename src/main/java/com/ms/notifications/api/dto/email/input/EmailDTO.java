package com.ms.notifications.api.dto.email.input;

public record EmailDTO(Long userId, String emailTo, String subject, String text) {
}
