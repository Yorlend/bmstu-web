package ru.bmstu.icsnetwork.presentation.controllers.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.presentation.responses.PostApiResponse;
import ru.bmstu.icsnetwork.presentation.responses.UserApiResponse;

public class AddPostOutputMapper {
    public static ResponseEntity<PostApiResponse> map(PostModel post) {
        return new ResponseEntity<PostApiResponse>(
            PostApiResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .user(UserApiResponse.from(post.getAuthor()))
                .build(),
            HttpStatus.CREATED
        );
    }
}
