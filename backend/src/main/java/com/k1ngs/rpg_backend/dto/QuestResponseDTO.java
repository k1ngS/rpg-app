package com.k1ngs.rpg_backend.dto;

import com.k1ngs.rpg_backend.domain.QuestStatus;

import java.time.OffsetDateTime;

public record QuestResponseDTO(
        Long id, String title, String description,
        QuestStatus status, OffsetDateTime created
) { }
