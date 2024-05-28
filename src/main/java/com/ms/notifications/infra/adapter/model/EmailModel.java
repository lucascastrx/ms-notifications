package com.ms.notifications.infra.adapter.model;

import com.ms.notifications.domain.model.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_EMAIL")
@Entity
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    Long userId;
    String emailFrom;
    String emailTo;
    String subject;
    @Column(columnDefinition = "TEXT")
    String text;
    LocalDateTime createdAt;
    StatusEmail status;
}
