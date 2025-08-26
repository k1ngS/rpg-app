package com.k1ngs.rpg_backend.repo;

import com.k1ngs.rpg_backend.domain.Quest;
import com.k1ngs.rpg_backend.domain.QuestStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest,Long> {
    Page<Quest> findByStatus(QuestStatus status, Pageable pageable);
}
