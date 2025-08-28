package com.k1ngs.rpg_backend.mapper;

import com.k1ngs.rpg_backend.domain.InventoryItem;
import com.k1ngs.rpg_backend.dto.InventoryItemResponseDTO;
import com.k1ngs.rpg_backend.domain.Item;

public class InventoryItemMapper {
    public static InventoryItemResponseDTO toResponseDTO(InventoryItem inventoryItem) {
        InventoryItemResponseDTO dto = new InventoryItemResponseDTO();
        dto.setId(inventoryItem.getId());
        dto.setItemId(inventoryItem.getItem().getId());
        dto.setItemName(inventoryItem.getItem().getName());
        dto.setQuantity(inventoryItem.getQuantity());
        // Expanda conforme seu DTO (description, raridade, etc) se quiser
        // dto.setItemDescription(inventoryItem.getItem().getDescription());
        // dto.setItemType(inventoryItem.getItem().getType().name());
        // dto.setItemRarity(inventoryItem.getItem().getRarity().name());
        return dto;
    }
}
