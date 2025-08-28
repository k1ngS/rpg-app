package com.k1ngs.rpg_backend.domain;

public enum PlayerCharacterClass {
    WARRIOR("Guerreiro"),
    MAGE("Mago"),
    CLERIC("Clerigo");

    private final String displayName;
    PlayerCharacterClass(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
