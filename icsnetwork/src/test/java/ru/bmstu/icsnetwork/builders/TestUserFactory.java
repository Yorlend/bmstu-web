package ru.bmstu.icsnetwork.builders;

import com.github.javafaker.Faker;
import lombok.val;
import ru.bmstu.icsnetwork.data.entities.UserEntity;
import ru.bmstu.icsnetwork.domain.models.UserModel;

import java.util.List;

public class TestUserFactory {
    public static UserModel createRandom() {
        val user = new UserModel();
        user.setId(Faker.instance().random().nextLong());
        user.setName(Faker.instance().name().fullName());
        user.setPosts(List.of());
        user.setComments(List.of());
        user.setVotes(List.of());
        user.setLogin(Faker.instance().name().username());
        user.setPassword(Faker.instance().internet().password());
        return user;
    }

    public static UserEntity toEntity(UserModel user) {
        val entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setPosts(List.of());
        entity.setComments(List.of());
        entity.setVotes(List.of());
        return entity;
    }
}
