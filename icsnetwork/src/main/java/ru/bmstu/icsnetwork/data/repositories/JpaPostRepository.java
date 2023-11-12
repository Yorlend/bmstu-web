package ru.bmstu.icsnetwork.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.bmstu.icsnetwork.data.entities.PostEntity;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {
    
}
