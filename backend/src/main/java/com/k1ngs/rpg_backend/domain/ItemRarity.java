package com.k1ngs.rpg_backend.domain;

public enum ItemRarity {
    COMMON("Comum"),
    RARE("Raro"),
    EPIC("Épico"),
    LEGENDARY("Lendário");

    private final String displayName;
    ItemRarity(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}
