package com.k1ngs.rpg_backend.web;

import com.k1ngs.rpg_backend.dto.PlayerCharacterCreateDTO;
import com.k1ngs.rpg_backend.dto.PlayerCharacterResponseDTO;
import com.k1ngs.rpg_backend.dto.PlayerCharacterUpdateDTO;
import com.k1ngs.rpg_backend.mapper.PlayerCharacterMapper;
import com.k1ngs.rpg_backend.service.PlayerCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class PlayerCharacterController {

    private final PlayerCharacterService playerCharacterService;

    @Autowired
    public PlayerCharacterController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }

    @PostMapping
    public ResponseEntity<PlayerCharacterResponseDTO> create(@RequestBody @Validated PlayerCharacterCreateDTO createDTO) {
        PlayerCharacterResponseDTO response = playerCharacterService.create(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<PlayerCharacterResponseDTO> listAll() {
        return playerCharacterService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerCharacterResponseDTO> getById(@PathVariable("id") Long id) {
        PlayerCharacterResponseDTO dto = playerCharacterService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerCharacterResponseDTO> update(
            @PathVariable("id") Long id,
            @RequestBody @Validated PlayerCharacterUpdateDTO updateDTO) {
        PlayerCharacterResponseDTO updated = playerCharacterService.update(id, updateDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        playerCharacterService.delete(id);
    }


    @GetMapping("/code/{code}")
    public ResponseEntity<PlayerCharacterResponseDTO> getByCode(@PathVariable("code") String code) {
        return playerCharacterService
                .findByCharacterCode(code)
                .map(PlayerCharacterMapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}