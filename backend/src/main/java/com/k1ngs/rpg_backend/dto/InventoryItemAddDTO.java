package com.k1ngs.rpg_backend.dto;

public class InventoryItemAddDTO {
    private Long characterId;

    private Long itemId;

    private int quantity;

    // Getters/setters
    public Long getCharacterId() { return characterId; }
    public void setCharacterId(Long characterId) { this.characterId = characterId; }
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
