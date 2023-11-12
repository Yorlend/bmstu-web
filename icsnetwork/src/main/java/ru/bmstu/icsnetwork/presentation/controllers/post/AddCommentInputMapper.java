package ru.bmstu.icsnetwork.presentation.controllers.post;

import ru.bmstu.icsnetwork.domain.usecases.post.AddCommentUseCase;
import ru.bmstu.icsnetwork.presentation.requests.PostCommentApiRequest;
import ru.bmstu.icsnetwork.presentation.security.UserPrincipal;

public class AddCommentInputMapper {

    public static AddCommentUseCase.Input map(long postId, PostCommentApiRequest request, UserPrincipal user) {
        return new AddCommentUseCase.Input(
                postId,
                user.toUserModel(),
                request.getContent()
        );
    }
}
