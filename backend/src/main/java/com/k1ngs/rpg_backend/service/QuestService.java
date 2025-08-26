package com.k1ngs.rpg_backend.service;

import com.k1ngs.rpg_backend.domain.*;
import com.k1ngs.rpg_backend.dto.*;
import com.k1ngs.rpg_backend.repo.QuestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestService {
    private final QuestRepository repo;
    public QuestService(QuestRepository repo){ this.repo = repo; }

    public QuestResponseDTO create(QuestCreateDTO in) {
        var q = new Quest();
        q.setTitle(in.title());
        q.setDescription(in.description());
        q.setStatus(QuestStatus.ACTIVE);
        q = repo.save(q);
        return toDTO(q);
    }

    public Page<QuestResponseDTO> list(QuestStatus status, Pageable pageable) {
        var page = (status == null)
                ? repo.findAll(pageable)
                : repo.findByStatus(status, pageable);
        return page.map(this::toDTO);
    }

    private QuestResponseDTO toDTO(Quest q) {
        return new QuestResponseDTO(q.getId(), q.getTitle(), q.getDescription(),
                q.getStatus(), q.getCreatedAt());
    }
}
