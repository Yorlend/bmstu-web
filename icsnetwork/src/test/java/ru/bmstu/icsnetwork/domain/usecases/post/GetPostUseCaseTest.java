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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
class GetPostUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Test
    @DisplayName("Should get post by id")
    void getPostById() {
        val useCase = new GetPostUseCase(postRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);
        when(postRepository.findPostById(post.getId())).thenReturn(Optional.of(post));

        val output = useCase.execute(
                new GetPostUseCase.Input(post.getId())
        );

        assertTrue(output.getPost().isPresent());
        assertEquals(post.getTitle(), output.getPost().get().getTitle());
        assertEquals(post.getContent(), output.getPost().get().getContent());
        assertEquals(post.getAuthor(), output.getPost().get().getAuthor());
    }
}