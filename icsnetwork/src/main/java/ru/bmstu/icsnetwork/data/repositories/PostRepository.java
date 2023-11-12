package ru.bmstu.icsnetwork.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.val;
import ru.bmstu.icsnetwork.domain.models.CommentModel;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.mappers.CommentMapper;
import ru.bmstu.icsnetwork.mappers.PostMapper;

@Repository
public class PostRepository implements IPostRepository {

    private final JpaPostRepository jpaPostRepository;
    private final JpaCommentRepository jpaCommentRepository;

    public PostRepository(JpaPostRepository jpaPostRepository, JpaCommentRepository jpaCommentRepository) {
        this.jpaPostRepository = jpaPostRepository;
        this.jpaCommentRepository = jpaCommentRepository;
    }

    @Override
    public PostModel persistPost(PostModel postModel) {
        val inserted = jpaPostRepository.save(
            PostMapper.postEntityFromModel(postModel)
        );
        return PostMapper.postModelFromEntity(inserted);
    }

    @Override
    public List<PostModel> findAllPosts() {
        return jpaPostRepository.findAll().stream().map(PostMapper::postModelFromEntity).toList();
    }

    @Override
    public Optional<PostModel> findPostById(Long id) {
        return jpaPostRepository.findById(id).map(PostMapper::postModelFromEntity);
    }

    @Override
    public List<CommentModel> findCommentsByPostId(Long id) {
        return jpaCommentRepository.findAllByPostId(id).stream().map(CommentMapper::commentModelFromEntity).toList();
    }

    @Override
    public CommentModel persistComment(CommentModel commentModel) {
        val inserted = jpaCommentRepository.save(
            CommentMapper.commentEntityFromModel(commentModel)
        );
        return CommentMapper.commentModelFromEntity(inserted);
    }
    
}
