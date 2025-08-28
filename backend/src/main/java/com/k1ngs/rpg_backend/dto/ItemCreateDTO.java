package com.k1ngs.rpg_backend.dto;

import com.k1ngs.rpg_backend.domain.ItemRarity;
import com.k1ngs.rpg_backend.domain.ItemType;

public class ItemCreateDTO {
    private String name;
    private String description;
    private ItemType type;
    private ItemRarity rarity;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public ItemType getType() { return type; }
    public void setType(ItemType type) { this.type = type; }
    public ItemRarity getRarity() { return rarity; }
    public void setRarity(ItemRarity rarity) { this.rarity = rarity; }
}
