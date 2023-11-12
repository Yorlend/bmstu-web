package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

import java.util.List;

public class GetAllPostsUseCase extends UseCase<GetAllPostsUseCase.Input, GetAllPostsUseCase.Output> {

    private final IPostRepository postRepository;

    public GetAllPostsUseCase(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Output execute(Input input) {
        return new Output(postRepository.findAllPosts());
    }

    public static class Input implements UseCase.Input { }

    @Value
    public static class Output implements UseCase.Output {
        List<PostModel> posts;
    }
}
