package com.k1ngs.rpg_backend.dto;

import com.k1ngs.rpg_backend.domain.PlayerCharacterClass;
import com.k1ngs.rpg_backend.domain.PlayerCharacterAncestry;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlayerCharacterUpdateDTO {

    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
    private String name;

    @NotNull(message = "A classe não pode ser nula")
    private PlayerCharacterClass playerCharacterClass;

    @NotNull(message = "A ancestralidade não pode ser nula")
    private PlayerCharacterAncestry playerCharacterAncestry;

    @NotNull(message = "Os atributos não podem ser nulos")
    private PlayerCharacterAttributesDTO attributes;

    @NotNull
    @Min(1)
    @Max(20)
    private Integer level;

    private Integer defense;
    private Integer health;
    private Integer corruption;
    private Integer insanity;
    private Integer fortune;

    // getters e setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public PlayerCharacterClass getPlayerCharacterClass() { return playerCharacterClass; }
    public void setPlayerCharacterClass(PlayerCharacterClass playerCharacterClass) { this.playerCharacterClass = playerCharacterClass; }

    public PlayerCharacterAncestry getPlayerCharacterAncestry() { return playerCharacterAncestry; }
    public void setPlayerCharacterAncestry(PlayerCharacterAncestry playerCharacterAncestry) { this.playerCharacterAncestry = playerCharacterAncestry; }

    public PlayerCharacterAttributesDTO getAttributes() { return attributes; }
    public void setAttributes(PlayerCharacterAttributesDTO attributes) { this.attributes = attributes; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }

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
