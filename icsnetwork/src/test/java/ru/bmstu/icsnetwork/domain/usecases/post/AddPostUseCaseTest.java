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
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
class AddPostUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Mock
    PostModel postMock;

    @Mock
    UserModel userMock;

    @Test
    @DisplayName("Should add post")
    void addPost() {
        val useCase = new AddPostUseCase(postRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);
        when(postRepository.persistPost(any(PostModel.class))).then(invocation -> {
            val entity = (PostModel) invocation.getArgument(0);
            entity.setId(1L);
            return entity;
        });

        val output = useCase.execute(
                new AddPostUseCase.Input(
                        post.getTitle(),
                        post.getContent(),
                        post.getAuthor()
                )
        );

        assertEquals(1L, output.getPost().getId());
        assertEquals(post.getTitle(), output.getPost().getTitle());
        assertEquals(post.getContent(), output.getPost().getContent());
        assertEquals(post.getAuthor(), output.getPost().getAuthor());
    }

    @Test
    @DisplayName("Should add post (London)")
    void addPostLondon() {
        val useCase = new AddPostUseCase(postRepository);
        when(postRepository.persistPost(any(PostModel.class))).then(invocation -> {
            val post = (PostModel) invocation.getArgument(0);
            post.setId(1L);
            return post;
        });

        val output = useCase.execute(
                new AddPostUseCase.Input(
                        "London",
                        "London is the capital of Great Britain",
                        userMock
                )
        );

        assertEquals(1L, output.getPost().getId());
        assertEquals("London", output.getPost().getTitle());
        assertEquals("London is the capital of Great Britain", output.getPost().getContent());
    }
}