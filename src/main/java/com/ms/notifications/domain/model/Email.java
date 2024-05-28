package com.ms.notifications.domain.model;

import java.time.LocalDateTime;

public class Email {
    Long id;

    Long userId;
    String emailFrom;
    String emailTo;
    String subject;
    String text;
    LocalDateTime createdAt;
    StatusEmail status;

    public Email() {
    }

    public Email(Long id, Long userId, String emailFrom, String emailTo, String subject, String text, LocalDateTime createdAt, StatusEmail status) {
        this.id = id;
        this.userId = userId;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public StatusEmail getStatus() {
        return status;
    }

    public void setStatus(StatusEmail status) {
        this.status = status;
    }
}
