package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

import java.util.Optional;

public class GetPostUseCase extends UseCase<GetPostUseCase.Input, GetPostUseCase.Output> {

    private final IPostRepository postRepository;

    public GetPostUseCase(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Output execute(Input input) {
        return new Output(postRepository.findPostById(input.id));
    }

    @Value
    public static class Input implements UseCase.Input {
        long id;
    }

    @Value
    public static class Output implements UseCase.Output {
        Optional<PostModel> post;
    }
}
