package ru.bmstu.icsnetwork.presentation.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Builder
@Value
public class PostCommentApiRequest {
    String content;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PostCommentApiRequest(
            @JsonProperty("content") String content
    ) {
        this.content = content;
    }
}
