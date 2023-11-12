package ru.bmstu.icsnetwork.presentation.controllers.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.bmstu.icsnetwork.domain.models.CommentModel;
import ru.bmstu.icsnetwork.presentation.responses.CommentApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.PostApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.UserApiResponse;

public class AddCommentOutputMapper {

    public static ResponseEntity<CommentApiResponse> map(CommentModel comment) {
        return new ResponseEntity<CommentApiResponse>(
            CommentApiResponse.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .post(PostApiResponse.from(comment.getPost()))
                .author(UserApiResponse.from(comment.getAuthor()))
                .build(),
            HttpStatus.CREATED
        );
    }
}
