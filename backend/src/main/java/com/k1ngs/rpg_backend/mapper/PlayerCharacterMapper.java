package com.k1ngs.rpg_backend.mapper;

import com.k1ngs.rpg_backend.domain.PlayerCharacter;
import com.k1ngs.rpg_backend.domain.PlayerCharacterAttributes;
import com.k1ngs.rpg_backend.dto.PlayerCharacterCreateDTO;
import com.k1ngs.rpg_backend.dto.PlayerCharacterResponseDTO;
import com.k1ngs.rpg_backend.dto.PlayerCharacterAttributesDTO;
import com.k1ngs.rpg_backend.dto.PlayerCharacterUpdateDTO;

import java.time.ZoneOffset;

public class PlayerCharacterMapper {

    public static PlayerCharacter toEntity(PlayerCharacterCreateDTO dto) {
        if (dto == null) return null;
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.setName(dto.getName());
        playerCharacter.setLevel(dto.getLevel());
        playerCharacter.setCharacterClass(dto.getCharacterClass());
        playerCharacter.setCharacterAncestry(dto.getCharacterAncestry());
        playerCharacter.setCharacterAttributes(attributesToEntity(dto.getAttributes()));
        playerCharacter.setDefense(dto.getDefense());
        playerCharacter.setHealth(dto.getHealth());
        playerCharacter.setCorruption(dto.getCorruption());
        playerCharacter.setInsanity(dto.getInsanity());
        playerCharacter.setFortune(dto.getFortune());
        return playerCharacter;
    }

    public static PlayerCharacterResponseDTO toResponseDTO(PlayerCharacter playerCharacter) {
        if (playerCharacter == null) return null;
        PlayerCharacterResponseDTO dto = new PlayerCharacterResponseDTO();
        dto.setId(playerCharacter.getId());
        dto.setName(playerCharacter.getName());
        dto.setLevel(playerCharacter.getLevel());
        dto.setCharacterClass(playerCharacter.getCharacterClass());
        dto.setCharacterAncestry(playerCharacter.getCharacterAncestry());
        dto.setAttributes(attributesToDTO(playerCharacter.getCharacterAttributes()));
        dto.setDefense(playerCharacter.getDefense());
        dto.setHealth(playerCharacter.getHealth());
        dto.setCorruption(playerCharacter.getCorruption());
        dto.setInsanity(playerCharacter.getInsanity());
        dto.setFortune(playerCharacter.getFortune());
        dto.setCharacterCode(playerCharacter.getCharacterCode());
        dto.setCreatedAt(playerCharacter.getCreatedAt().atOffset(ZoneOffset.UTC));
        dto.setUpdatedAt(playerCharacter.getUpdatedAt().atOffset(ZoneOffset.UTC));
        return dto;
    }

    public static void updateEntityFromDTO(PlayerCharacter entity, PlayerCharacterUpdateDTO dto) {
        entity.setName(dto.getName());
        entity.setCharacterClass(dto.getPlayerCharacterClass());
        entity.setCharacterAncestry(dto.getPlayerCharacterAncestry());
        entity.setCharacterAttributes(attributesToEntity(dto.getAttributes()));
        entity.setLevel(dto.getLevel());
        entity.setDefense(dto.getDefense());
        entity.setHealth(dto.getHealth());
        entity.setCorruption(dto.getCorruption());
        entity.setInsanity(dto.getInsanity());
        entity.setFortune(dto.getFortune());
    }


    // Métodos auxiliares para o mapeamento de CharacterAttributes

    public static PlayerCharacterAttributes attributesToEntity(PlayerCharacterAttributesDTO dto) {
        if (dto == null) return null;
        PlayerCharacterAttributes attr = new PlayerCharacterAttributes();
        attr.setStrength(dto.getStrength());
        attr.setAgility(dto.getAgility());
        attr.setIntelligence(dto.getIntelligence());
        attr.setWill(dto.getWill());
        return attr;
    }

    public static PlayerCharacterAttributesDTO attributesToDTO(PlayerCharacterAttributes entity) {
        if (entity == null) return null;
        PlayerCharacterAttributesDTO dto = new PlayerCharacterAttributesDTO();
        dto.setStrength(entity.getStrength());
        dto.setAgility(entity.getAgility());
        dto.setIntelligence(entity.getIntelligence());
        dto.setWill(entity.getWill());
        return dto;
    }
}
