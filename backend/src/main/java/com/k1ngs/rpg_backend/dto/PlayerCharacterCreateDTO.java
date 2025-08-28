package com.k1ngs.rpg_backend.dto;

import com.k1ngs.rpg_backend.domain.PlayerCharacterAncestry;
import com.k1ngs.rpg_backend.domain.PlayerCharacterClass;
import jakarta.validation.constraints.NotNull;

public class PlayerCharacterCreateDTO {

    @NotNull
    private String name;

    @NotNull
    private PlayerCharacterClass playerCharacterClass;

    @NotNull
    private Integer level;

    @NotNull
    private PlayerCharacterAncestry playerCharacterAncestry;

    @NotNull
    private PlayerCharacterAttributesDTO attributes;

    private Integer defense;
    private Integer health;
    private Integer corruption;
    private Integer insanity;
    private Integer fortune;

    public PlayerCharacterCreateDTO() {}

    // getters e setters
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
}
