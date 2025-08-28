package com.k1ngs.rpg_backend.domain;

public enum PlayerCharacterAncestry {
    HUMAN("Humano"),
    ELF("Elfo"),
    DWARF("Anão"),
    GOBLIN("Goblin");

    private final String displayName;
    PlayerCharacterAncestry(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
