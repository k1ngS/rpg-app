package com.k1ngs.rpg_backend.service;

import com.k1ngs.rpg_backend.domain.InventoryItem;
import com.k1ngs.rpg_backend.dto.InventoryItemAddDTO;
import com.k1ngs.rpg_backend.dto.InventoryItemResponseDTO;
import com.k1ngs.rpg_backend.repo.InventoryItemRepository;
import com.k1ngs.rpg_backend.repo.ItemRepository;
import com.k1ngs.rpg_backend.repo.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryItemRepository inventoryRepo;

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private PlayerCharacterRepository characterRepo;

    // Adicionar item ao inventário
    @Transactional
    public InventoryItemResponseDTO addItemToInventory(InventoryItemAddDTO dto) {
        var character = characterRepo.findById(dto.getCharacterId())
                .orElseThrow(() -> new RuntimeException("Character not found"));
        var item = itemRepo.findById(dto.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        var invOpt = inventoryRepo.findByCharacterIdAndItemId(dto.getCharacterId(), dto.getItemId());
        InventoryItem inv;
        if (invOpt.isPresent()) {
            inv = invOpt.get();
            inv.setQuantity(inv.getQuantity() + dto.getQuantity());
        } else {
            inv = new InventoryItem(character, item, dto.getQuantity());
        }
        inventoryRepo.save(inv);

        return toResponseDTO(inv);
    }

    // Listar inventário de personagem
    @Transactional(readOnly = true)
    public List<InventoryItemResponseDTO> listInventory(Long characterId) {
        return inventoryRepo.findByCharacterId(characterId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Utilitário de conversão
    private InventoryItemResponseDTO toResponseDTO(InventoryItem inv) {
        InventoryItemResponseDTO dto = new InventoryItemResponseDTO();
        dto.setId(inv.getId());
        dto.setItemId(inv.getItem().getId());
        dto.setItemName(inv.getItem().getName());
        dto.setQuantity(inv.getQuantity());
        return dto;
    }
}
