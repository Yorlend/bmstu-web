package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.Value;
import lombok.val;
import ru.bmstu.icsnetwork.domain.models.CommentModel;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

public class AddCommentUseCase extends UseCase<AddCommentUseCase.Input, AddCommentUseCase.Output> {

    private final IPostRepository postRepository;

    public AddCommentUseCase(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Output execute(Input input) {
        val post = postRepository.findPostById(input.postId);
        return post.map(postModel -> new Output(
                postRepository.persistComment(
                        CommentModel.builder()
                                .author(input.author)
                                .post(postModel)
                                .content(input.content)
                                .build()
                )
        )).orElse(null);
    }

    @Value
    public static class Input implements UseCase.Input {
        long postId;
        UserModel author;
        String content;
    }

    @Value
    public static class Output implements UseCase.Output {
        CommentModel comment;
    }
}
