package ru.bmstu.icsnetwork.domain.usecases.post;

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
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
class GetAllCommentsUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Test
    @DisplayName("Should get empty list if there are no comments")
    void getEmptyCommentsList() {
        val usecase = new GetAllCommentsUseCase(postRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);
        when(postRepository.findCommentsByPostId(post.getId())).thenReturn(List.of());

        val output = usecase.execute(
                new GetAllCommentsUseCase.Input(post.getId())
        );

        assertTrue(output.getComments().isEmpty());
    }
}