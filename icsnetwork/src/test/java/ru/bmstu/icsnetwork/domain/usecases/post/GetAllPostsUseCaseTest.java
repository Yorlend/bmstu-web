package ru.bmstu.icsnetwork.domain.usecases.post;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.bmstu.icsnetwork.domain.repositories.IPostRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.Random.class)
class GetAllPostsUseCaseTest {

    @Mock
    IPostRepository postRepository;

    @Test
    @DisplayName("Should get empty list if there are no posts")
    void getEmptyPostsList() {
        val usecase = new GetAllPostsUseCase(postRepository);
        when(postRepository.findAllPosts()).thenReturn(List.of());

        val output = usecase.execute(
                new GetAllPostsUseCase.Input()
        );

        assertTrue(output.getPosts().isEmpty());
    }
}