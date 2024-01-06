package ru.bmstu.icsnetwork.builders;

import com.github.javafaker.Faker;
import lombok.val;
import ru.bmstu.icsnetwork.data.entities.PostEntity;
import ru.bmstu.icsnetwork.data.entities.UserEntity;
import ru.bmstu.icsnetwork.domain.models.PostModel;
import ru.bmstu.icsnetwork.domain.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class TestPostFactory {
    public static PostModel createRandom(UserModel author) {
        val post = new PostModel();
        post.setId(Faker.instance().random().nextLong());
        post.setTitle(Faker.instance().book().title());
        post.setContent(Faker.instance().lorem().paragraph());
        post.setAuthor(author);
        post.setVotes(List.of());
        return post;
    }

    public static List<PostModel> createRandomList(int size, UserModel author) {
        val list = new ArrayList<PostModel>(size);
        for (int i = 0; i < size; i++) {
            list.add(createRandom(author));
        }
        return list;
    }

    public static PostEntity toEntity(PostModel post, UserEntity authorEntity) {
        val entity = new PostEntity();
        entity.setId(post.getId());
        entity.setTitle(post.getTitle());
        entity.setContent(post.getContent());
        entity.setAuthor(authorEntity);
        return entity;
    }

    public static List<PostEntity> toEntityList(List<PostModel> list, UserEntity authorEntity) {
        val entities = new ArrayList<PostEntity>(list.size());
        for (PostModel post : list) {
            entities.add(toEntity(post, authorEntity));
        }
        return entities;
    }
}
