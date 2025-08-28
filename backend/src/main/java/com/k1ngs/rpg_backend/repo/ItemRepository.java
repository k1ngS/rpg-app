package com.k1ngs.rpg_backend.repo;

import com.k1ngs.rpg_backend.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> { }
