package ru.bmstu.icsnetwork.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.icsnetwork.data.entities.UserEntity;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
}
