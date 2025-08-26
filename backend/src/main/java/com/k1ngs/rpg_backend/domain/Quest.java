package com.k1ngs.rpg_backend.domain;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class Quest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private QuestStatus status = QuestStatus.DRAFT;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    // --- Constructors ---
    public Quest() {}

    public Quest(Long id, String title, String description, QuestStatus status, OffsetDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status != null ? status : QuestStatus.DRAFT;
        this.createdAt = createdAt != null ? createdAt : OffsetDateTime.now();
    }

    // Convenience constructor for create flows
    public Quest(String title, String description) {
        this(null, title, description, QuestStatus.DRAFT, OffsetDateTime.now());
    }

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuestStatus getStatus() {
        return status;
    }

    public void setStatus(QuestStatus status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
