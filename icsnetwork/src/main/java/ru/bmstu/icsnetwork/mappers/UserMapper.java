package ru.bmstu.icsnetwork.mappers;

import ru.bmstu.icsnetwork.data.entities.UserEntity;
import ru.bmstu.icsnetwork.domain.models.UserModel;

public class UserMapper {
    public static UserEntity userEntityFromModel(UserModel userModel) {
        return UserEntity.builder()
                .id(userModel.getId())
                .login(userModel.getLogin())
                .name(userModel.getName())
                .username(userModel.getUsername())
                .password(userModel.getPassword())
                .build();
    }

    public static UserModel userModelFromEntity(UserEntity userEntity) {
        return UserModel.builder()
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .name(userEntity.getName())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
    }
}
