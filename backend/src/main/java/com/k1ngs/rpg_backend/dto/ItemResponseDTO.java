package com.k1ngs.rpg_backend.dto;

import com.k1ngs.rpg_backend.domain.ItemRarity;
import com.k1ngs.rpg_backend.domain.ItemType;

import java.time.OffsetDateTime;

public class ItemResponseDTO {
    private Long id;
    private String name;
    private String description;
    private ItemType type;
    private ItemRarity rarity;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }
    public ItemRarity getRarity() { return rarity; }
    public void setRarity(ItemRarity rarity) { this.rarity = rarity; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}
