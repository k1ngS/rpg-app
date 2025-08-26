package com.k1ngs.rpg_backend.web;

import com.k1ngs.rpg_backend.domain.QuestStatus;
import com.k1ngs.rpg_backend.dto.*;
import com.k1ngs.rpg_backend.service.QuestService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
public class QuestController {
    private final QuestService service;
    public QuestController(QuestService service){ this.service = service; }

    @PostMapping
    public QuestResponseDTO create(@RequestBody @Valid QuestCreateDTO in) {
        return service.create(in);
    }

    @GetMapping
    public Page<QuestResponseDTO> list(
            @RequestParam(name = "status", required = false) QuestStatus status,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return service.list(status, pageable);
    }
}