package com.k1ngs.rpg_backend.web;

import com.k1ngs.rpg_backend.domain.ItemRarity;
import com.k1ngs.rpg_backend.domain.ItemType;
import com.k1ngs.rpg_backend.domain.PlayerCharacterAncestry;
import com.k1ngs.rpg_backend.domain.PlayerCharacterClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enums")
public class EnumController {

    @GetMapping("/classes")
    public List<Map<String, String>> getClasses() {
        return Arrays.stream(PlayerCharacterClass.values())
                .map(v -> Map.of("key", v.name(), "label", v.getDisplayName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/ancestries")
    public List<Map<String, String>> getAncestries() {
        return Arrays.stream(PlayerCharacterAncestry.values())
                .map(v -> Map.of("key", v.name(), "label", v.getDisplayName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/item-types")
    public List<Map<String, String>> getItemTypes() {
        return Arrays.stream(ItemType.values())
                .map(v -> Map.of("key", v.name(), "label", v.getDisplayName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/rarities")
    public List<Map<String, String>> getRarities() {
        return Arrays.stream(ItemRarity.values())
                .map(v -> Map.of("key", v.name(), "label", v.getDisplayName()))
                .collect(Collectors.toList());
    }

    // Se adicionar mais enums, repita o padrão acima.
}
