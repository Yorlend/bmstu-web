package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.Value;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

public class PatchPostUseCase extends UseCase<PatchPostUseCase.Input, PatchPostUseCase.Output> {
    
    private final IPostRepository postRepository;

    public PatchPostUseCase(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Output execute(Input input) {
        postRepository.updateTitleAndContent(input.id, input.title, input.content);
        return new Output(
                postRepository.findPostById(input.id).orElseThrow()
        );
    }

    @Value
    public static class Input implements UseCase.Input {
        long id;
        String title;
        String content;
    }

    @Value
    public static class Output implements UseCase.Output {
        PostModel post;
    }
}
