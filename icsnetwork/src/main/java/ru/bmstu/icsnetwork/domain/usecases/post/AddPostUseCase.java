package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.Value;
import lombok.val;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

public class AddPostUseCase extends UseCase<AddPostUseCase.Input, AddPostUseCase.Output> {

    private final IPostRepository postRepository;

    public AddPostUseCase(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }
  
    @Override
    public Output execute(Input input) {
        val post = PostModel.builder()
                .title(input.title)
                .content(input.content)
                .author(input.author)
                .build();
            
        return new Output(postRepository.persistPost(post));
    }

    @Value
    public static class Input implements UseCase.Input {
        String title;
        String content;
        UserModel author;
    }

    @Value
    public static class Output implements UseCase.Output {
        PostModel post;
    }
}
