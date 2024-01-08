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
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
class PatchPostUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Test
    @DisplayName("Should patch post")
    void patchPost() {
        val useCase = new PatchPostUseCase(postRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);
        val newContent = Faker.instance().lorem().paragraph();
        when(postRepository.findPostById(post.getId())).thenReturn(Optional.of(
                PostModel.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(newContent)
                        .build()
        ));

        val output = useCase.execute(
                new PatchPostUseCase.Input(
                        post.getId(),
                        post.getTitle(),
                        newContent
                )
        );

        verify(postRepository).updateTitleAndContent(
                post.getId(),
                post.getTitle(),
                newContent
        );
        assertEquals(post.getId(), output.getPost().getId());
        assertEquals(post.getTitle(), output.getPost().getTitle());
        assertEquals(newContent, output.getPost().getContent());
    }
}