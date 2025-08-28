package com.k1ngs.rpg_backend.mapper;

import com.k1ngs.rpg_backend.domain.Item;
import com.k1ngs.rpg_backend.dto.ItemCreateDTO;
import com.k1ngs.rpg_backend.dto.ItemResponseDTO;

import java.time.ZoneOffset;

public class ItemMapper {
    public static Item toItem(ItemCreateDTO dto) {
        return new Item(
                dto.getName(),
                dto.getDescription(),
                dto.getType(),
                dto.getRarity()
        );
    }

    public static ItemResponseDTO toResponseDTO(Item item) {
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        dto.setType(item.getType());
        dto.setRarity(item.getRarity());
        dto.setCreatedAt(item.getCreatedAt().atOffset(ZoneOffset.UTC));
        dto.setUpdatedAt(item.getUpdatedAt().atOffset(ZoneOffset.UTC));
        return dto;
    }
}
