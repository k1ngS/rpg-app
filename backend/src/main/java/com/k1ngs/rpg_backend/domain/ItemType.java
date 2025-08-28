package com.k1ngs.rpg_backend.domain;

public enum ItemType {
    WEAPON("Arma"),
    ARMOR("Armadura"),
    CONSUMABLE("Consumível");

    private final String displayName;
    ItemType(String displayName) { this.displayName = displayName; }
    public String getDisplayName() { return displayName; }
}