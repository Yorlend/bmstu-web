package ru.bmstu.icsnetwork.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.icsnetwork.data.entities.CommentEntity;
import ru.bmstu.icsnetwork.data.entities.PostEntity;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE PostEntity p SET p.title = ?2, p.content = ?3 WHERE p.id = ?1")
    void updateTitleAndContent(Long id, String title, String content);
}
