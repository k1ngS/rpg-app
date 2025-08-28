package com.k1ngs.rpg_backend.dto;

import com.k1ngs.rpg_backend.domain.PlayerCharacterAncestry;
import com.k1ngs.rpg_backend.domain.PlayerCharacterClass;
import java.time.OffsetDateTime;

public class PlayerCharacterResponseDTO {

    private Long id;
    private String name;
    private PlayerCharacterClass playerCharacterClass;
    private Integer level;
    private PlayerCharacterAncestry playerCharacterAncestry;
    private PlayerCharacterAttributesDTO attributes;
    private Integer defense;
    private Integer health;
    private Integer corruption;
    private Integer insanity;
    private Integer fortune;
    private String characterCode;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public PlayerCharacterResponseDTO() {}

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public PlayerCharacterClass getCharacterClass() { return playerCharacterClass; }
    public void setCharacterClass(PlayerCharacterClass playerCharacterClass) { this.playerCharacterClass = playerCharacterClass; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }

    public PlayerCharacterAncestry getCharacterAncestry() { return playerCharacterAncestry; }
    public void setCharacterAncestry(PlayerCharacterAncestry playerCharacterAncestry) { this.playerCharacterAncestry = playerCharacterAncestry; }

    public PlayerCharacterAttributesDTO getAttributes() { return attributes; }
    public void setAttributes(PlayerCharacterAttributesDTO attributes) { this.attributes = attributes; }

    public Integer getDefense() { return defense; }
    public void setDefense(Integer defense) { this.defense = defense; }

    public Integer getHealth() { return health; }
    public void setHealth(Integer health) { this.health = health; }

    public Integer getCorruption() { return corruption; }
    public void setCorruption(Integer corruption) { this.corruption = corruption; }

    public Integer getInsanity() { return insanity; }
    public void setInsanity(Integer insanity) { this.insanity = insanity; }

    public Integer getFortune() { return fortune; }
    public void setFortune(Integer fortune) { this.fortune = fortune; }

    public String getCharacterCode() { return characterCode; }
    public void setCharacterCode(String characterCode) { this.characterCode = characterCode; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}
