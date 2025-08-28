package com.k1ngs.rpg_backend.service;

import com.k1ngs.rpg_backend.domain.PlayerCharacter;
import com.k1ngs.rpg_backend.dto.PlayerCharacterCreateDTO;
import com.k1ngs.rpg_backend.dto.PlayerCharacterResponseDTO;
import com.k1ngs.rpg_backend.dto.PlayerCharacterUpdateDTO;
import com.k1ngs.rpg_backend.mapper.PlayerCharacterMapper;
import com.k1ngs.rpg_backend.repo.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayerCharacterService {

    private final PlayerCharacterRepository playerCharacterRepository;

    @Autowired
    public PlayerCharacterService(PlayerCharacterRepository playerCharacterRepository) {
        this.playerCharacterRepository = playerCharacterRepository;
    }

    @Transactional
    public PlayerCharacterResponseDTO create(PlayerCharacterCreateDTO createDTO) {
        PlayerCharacter playerCharacter = PlayerCharacterMapper.toEntity(createDTO);
        playerCharacter.setCharacterCode("PC-" + UUID.randomUUID().toString().substring(0, 8));
        PlayerCharacter saved = playerCharacterRepository.save(playerCharacter);
        return PlayerCharacterMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<PlayerCharacterResponseDTO> findAll() {
        return playerCharacterRepository.findAll().stream()
                .map(PlayerCharacterMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlayerCharacterResponseDTO findById(Long id) {
        PlayerCharacter playerCharacter = playerCharacterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado id=" + id));
        return PlayerCharacterMapper.toResponseDTO(playerCharacter);
    }

    @Transactional(readOnly = true)
    public Optional<PlayerCharacter> findByCharacterCode(String characterCode) {
        return playerCharacterRepository.findByCharacterCode(characterCode);
    }

    @Transactional(readOnly = true)
    public PlayerCharacterResponseDTO update(Long id, PlayerCharacterUpdateDTO updateDTO) {
        PlayerCharacter pc = playerCharacterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado id=" + id));
        PlayerCharacterMapper.updateEntityFromDTO(pc, updateDTO);
        PlayerCharacter saved = playerCharacterRepository.save(pc);
        return PlayerCharacterMapper.toResponseDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        if (!playerCharacterRepository.existsById(id)) {
            throw new RuntimeException("Personagem não encontrado para deletar id=" + id);
        }
        playerCharacterRepository.deleteById(id);
    }

    // Caso queira atualizar o personagem no futuro, sugerimos criar o update a partir de CharacterUpdateDTO
}
