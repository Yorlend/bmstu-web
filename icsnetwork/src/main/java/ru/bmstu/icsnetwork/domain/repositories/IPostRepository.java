package ru.bmstu.icsnetwork.domain.repositories;

import java.util.List;
import java.util.Optional;

import ru.bmstu.icsnetwork.domain.models.CommentModel;
import ru.bmstu.icsnetwork.domain.models.PostModel;

public interface IPostRepository {
    PostModel persistPost(PostModel postModel);

    List<PostModel> findAllPosts();

    Optional<PostModel> findPostById(Long id);

    List<CommentModel> findCommentsByPostId(Long id);

    CommentModel persistComment(CommentModel commentModel);

    void updateTitleAndContent(Long id, String title, String content);

    CommentModel findCommentById(Long commentId);

    void deleteComment(Long commentId);
}
