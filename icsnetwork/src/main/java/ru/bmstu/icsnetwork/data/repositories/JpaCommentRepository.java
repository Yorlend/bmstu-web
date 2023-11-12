package ru.bmstu.icsnetwork.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import ru.bmstu.icsnetwork.data.entities.CommentEntity;

public interface JpaCommentRepository extends JpaRepository<CommentEntity, Long>{

    // @Query("SELECT c FROM CommentEntity c WHERE c.post.id = ?1")
    List<CommentEntity> findAllByPostId(Long postId);
}
