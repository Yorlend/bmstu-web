package ru.bmstu.icsnetwork.domain.repositories;

import ru.bmstu.icsnetwork.domain.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    UserModel persist(UserModel userModel);

    List<UserModel> findAll();

    Optional<UserModel> findById(Long id);

    Optional<UserModel> findByLogin(String login);

    void save(UserModel userModel);
}
