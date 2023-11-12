package ru.bmstu.icsnetwork.presentation.controllers.post;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.presentation.responses.PostApiResponse;

public class GetPostOutputMapper {

    public static ResponseEntity<PostApiResponse> map(Optional<PostModel> post) {
        return post.map(postModel -> ResponseEntity.ok(PostApiResponse.from(postModel))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
