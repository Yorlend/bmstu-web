package ru.bmstu.icsnetwork.presentation.responses;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.CommentModel;

import java.util.List;

@Value
public class GetAllCommentsApiResponse {
    List<CommentApiResponse> comments;

    public static GetAllCommentsApiResponse from(List<CommentModel> comments) {
        return new GetAllCommentsApiResponse(
            comments.stream()
                .map(CommentApiResponse::from)
                .toList()
        );
    }
}
