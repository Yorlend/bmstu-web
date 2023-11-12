package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Builder;
import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.CommentModel;

@Value
@Builder
public class CommentApiResponse {
    long id;
    String content;
    PostApiResponse post;
    UserApiResponse author;

    public static CommentApiResponse from(CommentModel comment) {
        return new CommentApiResponse(
            comment.getId(),
            comment.getContent(),
            PostApiResponse.from(comment.getPost()),
            UserApiResponse.from(comment.getAuthor())
        );
    }
}
