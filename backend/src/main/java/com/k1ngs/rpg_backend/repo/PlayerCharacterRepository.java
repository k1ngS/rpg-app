package com.k1ngs.rpg_backend.repo;

import com.k1ngs.rpg_backend.domain.PlayerCharacter;
import com.k1ngs.rpg_backend.dto.PlayerCharacterResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter,Long> {
    Optional<PlayerCharacter> findByCharacterCode(String characterCode);
}
