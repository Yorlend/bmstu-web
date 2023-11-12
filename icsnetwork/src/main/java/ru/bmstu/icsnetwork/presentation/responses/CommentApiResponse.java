package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Builder;
import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.CommentModel;

@Value
@Builder
public class CommentApiResponse {
    long id;
    String content;
    long post_id;
    UserApiResponse author;

    public static CommentApiResponse from(CommentModel comment) {
        return new CommentApiResponse(
            comment.getId(),
            comment.getContent(),
            comment.getPost().getId(),
            UserApiResponse.from(comment.getAuthor())
        );
    }
}
