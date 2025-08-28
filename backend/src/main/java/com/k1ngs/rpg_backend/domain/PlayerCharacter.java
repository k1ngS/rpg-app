package com.k1ngs.rpg_backend.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private PlayerCharacterClass playerCharacterClass;

    @Column(nullable = false)
    private Integer level;

    @Enumerated(EnumType.STRING)
    private PlayerCharacterAncestry playerCharacterAncestry;

    @Embedded
    private PlayerCharacterAttributes playerCharacterAttributes;

    @Column
    private Integer defense;

    @Column
    private Integer health;

    @Column
    private Integer corruption;

    @Column
    private Integer insanity;

    @Column
    private Integer fortune;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InventoryItem> inventory = new ArrayList<>();

    @Column(unique = true, nullable = false)
    private String characterCode;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // --- Constructors ---
    public PlayerCharacter() {}

    public PlayerCharacter(String name, Integer level, PlayerCharacterClass playerCharacterClass, PlayerCharacterAncestry playerCharacterAncestry,
                           PlayerCharacterAttributes attributes, Integer defense, Integer health, Integer corruption, Integer insanity, Integer fortune, List<InventoryItem> inventory) {
        this.name = name;
        this.level = level != null ? level : 0;
        this.playerCharacterClass = playerCharacterClass;
        this.playerCharacterAncestry = playerCharacterAncestry;
        this.playerCharacterAttributes = attributes != null ? attributes : new PlayerCharacterAttributes(0,0,0,0);
        this.defense = defense;
        this.health = health;
        this.corruption = corruption;
        this.insanity = insanity;
        this.fortune = fortune;
        this.inventory = inventory;
    }


    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }

    public PlayerCharacterClass getCharacterClass() { return playerCharacterClass; }
    public void setCharacterClass(PlayerCharacterClass playerCharacterClass) { this.playerCharacterClass = playerCharacterClass; }

    public PlayerCharacterAncestry getCharacterAncestry() { return playerCharacterAncestry; }
    public void  setCharacterAncestry(PlayerCharacterAncestry playerCharacterAncestry) { this.playerCharacterAncestry = playerCharacterAncestry; }

    public PlayerCharacterAttributes getCharacterAttributes() { return playerCharacterAttributes; }
    public void setCharacterAttributes(PlayerCharacterAttributes playerCharacterAttributes) { this.playerCharacterAttributes = playerCharacterAttributes; }

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

    public List<InventoryItem> getInventory() { return inventory; }
    public void setInventory(List<InventoryItem> inventory) { this.inventory = inventory; }

    public String getCharacterCode() { return characterCode; }
    public void setCharacterCode(String characterCode) { this.characterCode = characterCode; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
