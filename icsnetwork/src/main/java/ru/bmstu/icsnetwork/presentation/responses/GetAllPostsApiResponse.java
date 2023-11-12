package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.PostModel;

import java.util.List;

@Value
public class GetAllPostsApiResponse {
    List<PostApiResponse> posts;

    public static GetAllPostsApiResponse from(List<PostModel> posts) {
        return new GetAllPostsApiResponse(
            posts.stream()
                .map(PostApiResponse::from)
                .toList()
        );
    }
}
