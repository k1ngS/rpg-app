package com.k1ngs.rpg_backend.web;

import com.k1ngs.rpg_backend.domain.InventoryItem;
import com.k1ngs.rpg_backend.domain.PlayerCharacter;
import com.k1ngs.rpg_backend.domain.Item;
import com.k1ngs.rpg_backend.dto.InventoryItemAddDTO;
import com.k1ngs.rpg_backend.dto.InventoryItemResponseDTO;
import com.k1ngs.rpg_backend.mapper.InventoryItemMapper;
import com.k1ngs.rpg_backend.repo.InventoryItemRepository;
import com.k1ngs.rpg_backend.repo.PlayerCharacterRepository;
import com.k1ngs.rpg_backend.repo.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/characters/{characterId}/inventory")
public class InventoryController {
    private final InventoryItemRepository inventoryRepo;
    private final PlayerCharacterRepository characterRepo;
    private final ItemRepository itemRepo;

    public InventoryController(
            InventoryItemRepository inventoryRepo,
            PlayerCharacterRepository characterRepo,
            ItemRepository itemRepo
    ) {
        this.inventoryRepo = inventoryRepo;
        this.characterRepo = characterRepo;
        this.itemRepo = itemRepo;
    }

    // GET /characters/{characterId}/inventory
    @GetMapping
    public List<InventoryItemResponseDTO> getInventory(@PathVariable("characterId") Long characterId) {
        List<InventoryItem> inventory = inventoryRepo.findByCharacterId(characterId);
        return inventory.stream()
                .map(InventoryItemMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // POST /characters/{characterId}/inventory
    @PostMapping
    public InventoryItemResponseDTO addItem(
            @PathVariable("characterId") Long characterId,
            @RequestBody InventoryItemAddDTO dto
    ) {
        PlayerCharacter character = characterRepo.findById(characterId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found"));

        Item item = itemRepo.findById(dto.getItemId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));

        InventoryItem inv = new InventoryItem(character, item, dto.getQuantity());
        InventoryItem saved = inventoryRepo.save(inv);
        return InventoryItemMapper.toResponseDTO(saved);
    }

    // PUT /characters/{characterId}/inventory/{inventoryItemId}
    @PutMapping("/{inventoryItemId}")
    public InventoryItemResponseDTO updateItem(
            @PathVariable("characterId") Long characterId,
            @PathVariable("inventoryItemId") Long inventoryItemId,
            @RequestBody InventoryItemAddDTO dto
    ) {
        InventoryItem existing = inventoryRepo.findById(inventoryItemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory item not found"));

        if (!existing.getCharacter().getId().equals(characterId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inventory item does not belong to character");

        Item item = itemRepo.findById(dto.getItemId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));

        existing.setItem(item);
        existing.setQuantity(dto.getQuantity());

        InventoryItem updated = inventoryRepo.save(existing);
        return InventoryItemMapper.toResponseDTO(updated);
    }

    // DELETE /characters/{characterId}/inventory/{inventoryItemId}
    @DeleteMapping("/{inventoryItemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(
            @PathVariable("characterId") Long characterId,
            @PathVariable("inventoryItemId") Long inventoryItemId
    ) {
        InventoryItem item = inventoryRepo.findById(inventoryItemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory item not found"));

        if (!item.getCharacter().getId().equals(characterId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inventory item does not belong to character");

        inventoryRepo.delete(item);
    }
}
