package com.k1ngs.rpg_backend.domain;

import jakarta.persistence.*;

@Entity
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "character_id")
    private PlayerCharacter character;

    @ManyToOne(optional = false)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(nullable = false)
    private int quantity;

    // Getters e setters

    public InventoryItem() {}

    public InventoryItem(PlayerCharacter character, Item item, int quantity) {
        this.character = character;
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public PlayerCharacter getCharacter() { return character; }
    public void setCharacter(PlayerCharacter character) { this.character = character; }
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
