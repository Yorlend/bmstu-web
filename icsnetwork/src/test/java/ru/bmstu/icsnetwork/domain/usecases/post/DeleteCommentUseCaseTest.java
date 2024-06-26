package ru.bmstu.icsnetwork.domain.usecases.post;

import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
@TestMethodOrder(MethodOrderer.Random.class)
class DeleteCommentUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Test
    @DisplayName("Should delete comment")
    void deleteRegularComment() {
        val usecase = new DeleteCommentUseCase(postRepository);
        val author = TestUserFactory.createRandom();
        val comment = CommentModel.builder()
                .id(1L)
                .author(author)
                .content(Faker.instance().lorem().sentence())
                .build();
        when(postRepository.findCommentById(1L)).thenReturn(comment);

        usecase.execute(new DeleteCommentUseCase.Input(author.getId(), 1));

        verify(postRepository).deleteComment(1L);
    }
}