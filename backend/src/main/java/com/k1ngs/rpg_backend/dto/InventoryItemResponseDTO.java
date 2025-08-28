package com.k1ngs.rpg_backend.dto;

public class InventoryItemResponseDTO {
    private Long id;
    private Long itemId;
    private String itemName;
    private int quantity;
    private String itemType;
    private String itemRarity;

    // Getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public String getItemRarity() { return itemRarity; }
    public void setItemRarity(String itemRarity) { this.itemRarity = itemRarity; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
