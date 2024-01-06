package ru.bmstu.icsnetwork.domain.usecases.post;

import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.bmstu.icsnetwork.builders.TestPostFactory;
import ru.bmstu.icsnetwork.builders.TestUserFactory;
import ru.bmstu.icsnetwork.domain.models.CommentModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteCommentUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Test
    @DisplayName("Should delete comment")
    void deleteRegularComment() {
        val usecase = new DeleteCommentUseCase(postRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);
        val comment = new CommentModel();
        comment.setId(1L);
        comment.setAuthor(author);
        comment.setContent(Faker.instance().lorem().sentence());

        when(postRepository.findCommentById(1L)).thenReturn(comment);

        val output = usecase.execute(new DeleteCommentUseCase.Input(author.getId(), 1));

        verify(postRepository).deleteComment(1L);
    }
}