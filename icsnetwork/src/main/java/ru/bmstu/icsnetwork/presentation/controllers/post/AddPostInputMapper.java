package ru.bmstu.icsnetwork.presentation.controllers.post;

import ru.bmstu.icsnetwork.domain.usecases.post.AddPostUseCase;
import ru.bmstu.icsnetwork.presentation.requests.PostApiRequest;
import ru.bmstu.icsnetwork.presentation.security.UserPrincipal;

public class AddPostInputMapper {

    public static AddPostUseCase.Input map(PostApiRequest request, UserPrincipal user) {
        return new AddPostUseCase.Input(
                request.getTitle(),
                request.getContent(),
                user.toUserModel()
        );
    }
}
