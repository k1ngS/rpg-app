package com.k1ngs.rpg_backend.dto;

import jakarta.validation.constraints.NotNull;

public class PlayerCharacterAttributesDTO {

    @NotNull
    private Integer strength;
    @NotNull
    private Integer agility;
    @NotNull
    private Integer intelligence;
    @NotNull
    private Integer will;

    public PlayerCharacterAttributesDTO() {}

    // getters e setters
    public Integer getStrength() { return strength; }
    public void setStrength(Integer strength) { this.strength = strength; }

    public Integer getAgility() { return agility; }
    public void setAgility(Integer agility) { this.agility = agility; }

    public Integer getIntelligence() { return intelligence; }
    public void setIntelligence(Integer intelligence) { this.intelligence = intelligence; }

    public Integer getWill() { return will; }
    public void setWill(Integer will) { this.will = will; }
}
