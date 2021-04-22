package com.backend.repositories;

import com.backend.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepository extends JpaRepository<Card, Long> {
    Card findCardById(Long id);

    Card findCardByTitle(String title);
}
