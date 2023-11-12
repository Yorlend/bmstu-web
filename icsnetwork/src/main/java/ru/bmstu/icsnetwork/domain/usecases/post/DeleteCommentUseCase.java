package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.Value;
import lombok.val;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;
import ru.bmstu.icsnetwork.domain.usecases.UseCase;

public class DeleteCommentUseCase extends UseCase<DeleteCommentUseCase.Input, DeleteCommentUseCase.Output> {

    private IPostRepository postRepository;

    public DeleteCommentUseCase(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Output execute(Input input) {
        val comment = postRepository.findCommentById(input.commentId);
        if (comment.getAuthor().getId() == input.userId) {
            postRepository.deleteComment(input.commentId);
        }
        // TODO: THROW EXCEPTION
        return new Output();
    }

    @Value
    public static class Input implements UseCase.Input {
        long userId;
        long commentId;
    }

    public static class Output implements UseCase.Output { }
}
