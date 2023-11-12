package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.CommentModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

import java.util.List;

public class GetAllCommentsUseCase extends  UseCase<GetAllCommentsUseCase.Input, GetAllCommentsUseCase.Output> {

    private final IPostRepository postRepository;

    public GetAllCommentsUseCase(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Output execute(Input input) {
        return new Output(
            postRepository.findCommentsByPostId(input.postId)
        );
    }

    @Value
    public static class Input implements UseCase.Input {
        long postId;
    }

    @Value
    public static class Output implements UseCase.Output {
        List<CommentModel> comments;
    }
}
