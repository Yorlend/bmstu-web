package ru.bmstu.icsnetwork.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.bmstu.icsnetwork.data.entities.VoteEntity;

public interface JpaVoteRepository extends JpaRepository<VoteEntity, Long> {
    
}
