package com.k1ngs.rpg_backend.dto;

public class InventoryItemResponseDTO {
    private Long id;
    private Long itemId;
    private String itemName;
    private int quantity;
    // Pode expandir para detalhes do item se quiser

    // Getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
