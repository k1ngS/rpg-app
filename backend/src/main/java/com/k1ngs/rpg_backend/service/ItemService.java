package com.k1ngs.rpg_backend.service;

import com.k1ngs.rpg_backend.domain.Item;
import com.k1ngs.rpg_backend.dto.ItemCreateDTO;
import com.k1ngs.rpg_backend.dto.ItemResponseDTO;
import com.k1ngs.rpg_backend.dto.ItemUpdateDTO;
import com.k1ngs.rpg_backend.mapper.ItemMapper;
import com.k1ngs.rpg_backend.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public ItemResponseDTO createItem(ItemCreateDTO dto) {
        Item item = ItemMapper.toItem(dto);
        Item saved = itemRepository.save(item);
        return ItemMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<ItemResponseDTO> listAll() {
        return itemRepository.findAll().stream()
                .map(ItemMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ItemResponseDTO getById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found id=" + id));
        return ItemMapper.toResponseDTO(item);
    }

    @Transactional
    public ItemResponseDTO updateItem(Long id, ItemUpdateDTO dto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found id=" + id));
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setType(dto.getType());
        item.setRarity(dto.getRarity());
        Item updated = itemRepository.save(item);
        return ItemMapper.toResponseDTO(updated);
    }


    @Transactional
    public void deleteById(Long id) {
        if(!itemRepository.existsById(id)) {
            throw new RuntimeException("Item not found to delete id=" + id);
        }
        itemRepository.deleteById(id);
    }
}
