package com.k1ngs.rpg_backend.repo;

import com.k1ngs.rpg_backend.domain.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    List<InventoryItem> findByCharacterId(Long characterId);
    Optional<InventoryItem> findByCharacterIdAndItemId(Long characterId, Long itemId);
}
