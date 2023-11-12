package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Builder;
import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.PostModel;

@Value
@Builder
public class PostApiResponse {
    long id;
    String title;
    String content;
    UserApiResponse user;

    public static PostApiResponse from(PostModel post) {
        return PostApiResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .user(UserApiResponse.from(post.getAuthor()))
                .build();
    }
}
