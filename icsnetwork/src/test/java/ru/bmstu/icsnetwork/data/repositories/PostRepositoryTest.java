package ru.bmstu.icsnetwork.data.repositories;

import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.bmstu.icsnetwork.builders.TestPostFactory;
import ru.bmstu.icsnetwork.builders.TestUserFactory;
import ru.bmstu.icsnetwork.data.entities.CommentEntity;
import ru.bmstu.icsnetwork.data.entities.PostEntity;
import ru.bmstu.icsnetwork.domain.models.CommentModel;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.models.UserModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostRepositoryTest {

    @Mock
    JpaPostRepository jpaPostRepository;

    @Mock
    JpaCommentRepository jpaCommentRepository;

    @Test
    @DisplayName("Should store regular post")
    void persistRegularPost() {
        val repository = new PostRepository(jpaPostRepository, jpaCommentRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);

        when(jpaPostRepository.save(any(PostEntity.class))).then(invocation -> {
            val entity = (PostEntity) invocation.getArgument(0);
            entity.setId(1L);
            return entity;
        });

        val savedPost = repository.persistPost(post);

        assertEquals(1L, savedPost.getId());
        assertEquals(post.getTitle(), savedPost.getTitle());
        assertEquals(post.getContent(), savedPost.getContent());
    }

    @Test
    @DisplayName("Should return all posts")
    void findAllPosts() {
        val repository = new PostRepository(jpaPostRepository, jpaCommentRepository);
        val author = TestUserFactory.createRandom();
        val authorEntity = TestUserFactory.toEntity(author);
        val posts = TestPostFactory.createRandomList(3, author);
        val postEntities = TestPostFactory.toEntityList(posts, authorEntity);
        when(jpaPostRepository.findAll()).thenReturn(postEntities);

        val returnedPosts = repository.findAllPosts();

        assertEquals(posts, returnedPosts);
    }

    @Test
    @DisplayName("Should add comment to post")
    void persistComment() {
        val repository = new PostRepository(jpaPostRepository, jpaCommentRepository);
        val author = TestUserFactory.createRandom();
        val post = TestPostFactory.createRandom(author);
        val comment = new CommentModel();
        comment.setPost(post);
        comment.setAuthor(author);
        comment.setContent(Faker.instance().lorem().sentence());

        when(jpaCommentRepository.save(any(CommentEntity.class))).then(invocation -> {
            val entity = (CommentEntity) invocation.getArgument(0);
            entity.setId(1L);
            return entity;
        });

        val savedComment = repository.persistComment(comment);

        assertEquals(1L, savedComment.getId());
        assertEquals(comment.getContent(), savedComment.getContent());
        assertEquals(comment.getAuthor(), savedComment.getAuthor());
        assertEquals(comment.getPost(), savedComment.getPost());
    }
}