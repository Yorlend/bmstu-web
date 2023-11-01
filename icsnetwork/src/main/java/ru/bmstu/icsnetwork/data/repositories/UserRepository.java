package ru.bmstu.icsnetwork.data.repositories;

import org.springframework.stereotype.Repository;
import ru.bmstu.icsnetwork.data.entities.UserEntity;
import ru.bmstu.icsnetwork.mappers.UserMapper;
import ru.bmstu.icsnetwork.domain.models.UserModel;
import ru.bmstu.icsnetwork.domain.repositories.IUserRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
    @Override
    public UserModel persist(UserModel userModel) {
        final UserEntity user = UserMapper.userEntityFromModel(userModel);
        return UserMapper.userModelFromEntity(jpaUserRepository.save(user));
    }

    @Override
    public List<UserModel> findAll() {
        return jpaUserRepository.findAll().stream().map(UserMapper::userModelFromEntity).toList();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        final UserEntity user = jpaUserRepository.findById(id).orElseThrow();
        return Optional.of(UserMapper.userModelFromEntity(user));
    }

    @Override
    public Optional<UserModel> findByLogin(String login) {
        final UserEntity user = jpaUserRepository.findByLogin(login).orElseThrow();
        return Optional.of(UserMapper.userModelFromEntity(user));
    }
}
