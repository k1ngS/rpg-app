package com.k1ngs.rpg_backend.dto;
import jakarta.validation.constraints.NotBlank;

public record QuestCreateDTO (
    @NotBlank String title,
    String description
) {}
