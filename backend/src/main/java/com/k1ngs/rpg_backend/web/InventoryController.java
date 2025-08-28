package com.k1ngs.rpg_backend.web;

import com.k1ngs.rpg_backend.dto.InventoryItemAddDTO;
import com.k1ngs.rpg_backend.dto.InventoryItemResponseDTO;
import com.k1ngs.rpg_backend.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public InventoryItemResponseDTO addItem(@RequestBody InventoryItemAddDTO dto) {
        return inventoryService.addItemToInventory(dto);
    }

    @GetMapping("/character/{characterId}")
    public List<InventoryItemResponseDTO> listInventory(@PathVariable Long characterId) {
        return inventoryService.listInventory(characterId);
    }
}
