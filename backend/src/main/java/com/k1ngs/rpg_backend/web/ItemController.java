package com.k1ngs.rpg_backend.web;

import com.k1ngs.rpg_backend.dto.ItemCreateDTO;
import com.k1ngs.rpg_backend.dto.ItemResponseDTO;
import com.k1ngs.rpg_backend.dto.ItemUpdateDTO;
import com.k1ngs.rpg_backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ItemResponseDTO create(@RequestBody ItemCreateDTO dto) {
        return itemService.createItem(dto);
    }

    @GetMapping
    public List<ItemResponseDTO> listAll() {
        return itemService.listAll();
    }

    @GetMapping("/{id}")
    public ItemResponseDTO getById(@PathVariable Long id) {
        return itemService.getById(id);
    }

    @PutMapping("/{id}")
    public ItemResponseDTO update(@PathVariable Long id, @RequestBody ItemUpdateDTO dto) {
        return itemService.updateItem(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemService.deleteById(id);
    }
}
