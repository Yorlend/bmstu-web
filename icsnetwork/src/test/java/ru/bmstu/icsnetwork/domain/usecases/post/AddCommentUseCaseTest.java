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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
class AddCommentUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Test
    @DisplayName("Should add comment")
    void addComment() {
        val usecase = new AddCommentUseCase(postRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);
        val commentText = Faker.instance().lorem().sentence();
        when(postRepository.findPostById(post.getId())).thenReturn(Optional.of(post));
        when(postRepository.persistComment(any(CommentModel.class))).then(invocation -> {
            val entity = (CommentModel) invocation.getArgument(0);
            entity.setId(1L);
            return entity;
        });

        val output = usecase.execute(
                new AddCommentUseCase.Input(
                        post.getId(),
                        author,
                        commentText
                )
        );

        assertEquals(1L, output.getComment().getId());
        assertEquals(author, output.getComment().getAuthor());
        assertEquals(commentText, output.getComment().getContent());
    }
}