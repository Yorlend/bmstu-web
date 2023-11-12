package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PostApiResponse {
    long id;
    String title;
    String content;
    UserApiResponse user;
}
